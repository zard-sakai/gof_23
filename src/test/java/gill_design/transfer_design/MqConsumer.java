package gill_design.transfer_design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class MqConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("account.transfer.topic:demo")
    private String topic;

    @Autowired
    private AccountService accountService;

    @Value("account.transfer.topic.retryTimes:3")
    private int retryTimes;

    @Autowired
    private AccountMapper accountMapper;

    public void onMessage(List<Object> msgList){
        // 从 topic中获取消息，处理扣款逻辑；
        msgList.stream().forEach(item -> {
            for (int i = 0; i < retryTimes; i++) {
                String result = "fail";
                TransferReq msg = (TransferReq) item;
                try {
                    AccountLog toAccountLog = accountService.getAccountLog(msg.getToAccountNo(), msg.getToAccountNo());
                    if(Objects.nonNull(toAccountLog) && "success".equals(toAccountLog.getStatus())){
                        logger.info("requestNo={},accountNo={} 的收款请求已经处理成功",msg.getToAccountNo(), msg.getToAccountNo());
                        return;
                    }
                    // 处理收款请求
                    Account fromAccount = accountMapper.selectByAccountNo(msg.getFromAccountNo());
                    // 采用乐观锁以version字段作为区分，如果更新的行数为0，则表示收款失败
                    boolean addResult = accountMapper.addAmount(fromAccount, msg.getAmount());
                    if(!addResult){
                        String errorMsg = String.format("requestNo={},accountNo={} 的收款失败",msg.getToAccountNo(), msg.getToAccountNo());
                        throw new BusinessException("5x2",errorMsg);
                    }
                    result = "success";
                    break;
                } catch (Exception e) {
                    logger.warn("requestNo={},accountNo={} 的收款请求 处理失败重试",msg.getToAccountNo(), msg.getToAccountNo());
                }
                // 更新状态
                accountService.saveAllLog(msg,result);
                // 如果最终还是收款失败，平台应该要能够有补偿机制；比如从平台的账户扣钱；
                if("fail".equals(result)){
                    // todo 记录日志，或者发送补偿消息，处理收款失败情况；
                    // todo FailedReceiptTransferCompensationScheduler
                }
            }

        });
    }

}
