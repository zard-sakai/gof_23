package gill_design.transfer_design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private TransferLogMapper transferLogMapper;

    @Autowired
    private MqProducer producer;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean transfer(TransferReq transferReq) {
        // 幂等性校验：处理完成的请求直接返回
        TransferLog transferLog = getTransferLog(transferReq.getReqNo());
        if(Objects.nonNull(transferLog) && "success".equals(transferLog.getStatus())){
            logger.info("reqNo={} 的转账请求已经处理成功",transferReq.getReqNo());
            return true;
        }
        // 先处理扣款，再处理收款，确保资金安全
        AccountLog accountLog = getAccountLog(transferReq.getReqNo(),transferReq.getToAccountNo());
        if("success".equals(accountLog.getStatus())){
            logger.info("reqNo={} 的转账请求已经处理成功",transferReq.getReqNo());
            return true;
        }
        saveAllLog(transferReq,"init");
        // 处理扣款
        Account fromAccount = accountMapper.selectByAccountNo(transferReq.getFromAccountNo());
        // 采用乐观锁以version字段作为区分，如果更新的行数为0，则表示转账失败
        boolean deductResult = accountMapper.deductAmount(fromAccount, transferReq.getAmount());
        if(deductResult){
            String errorMsg = String.format("requestNo={},accountNo={} 的扣款失败",transferReq.getFromAccountNo(), transferReq.getToAccountNo());
            throw new BusinessException("5x1",errorMsg);
        }
        // 发送扣款成功消息到mq，消费者处理收款逻辑, 注意失败重试
        producer.sendSync(transferReq);
        return true;
    }

    @Override
    public Account getAccountByNo(String accountNo) {
        return accountMapper.selectByAccountNo(accountNo);
    }

    @Override
    public TransferLog getTransferLog(String requestNo) {
        return transferLogMapper.selectByRequestNo(requestNo);
    }

    @Override
    public void saveTransferLogStatus(String requestNo, String status) {
        // 幂等更新，查询是否存在，存在即更新，不存在插入
    }

    @Override
    public AccountLog getAccountLog(String requestNo,String accountNo) {
        return null;
    }

    @Override
    public boolean saveAccountLog(TransferReq transferReq,String status) {
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveAllLog(TransferReq transferReq, String status) {
        // 更新状态
        saveTransferLogStatus(transferReq.getToAccountNo(),status);
        saveAccountLog(transferReq,status);
    }
}
