package gill_design.transfer_design;

import io.netty.util.internal.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

@DubboService
public class AccountFacadeImpl implements AccountFacade{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AccountService accountService;

    @Override
    public Response transfer(TransferReq transferReq) {
        try {
            logger.info("转账请求处理：入参：{}",transferReq);
            // 1. 入参校验
            validParam(transferReq);
            // 2. 账户有效性校验
            validAccount(transferReq);
            // 3. 账户余额校验
            validBalance(transferReq);
            // 4. 处理转账请求
            boolean transferResult = accountService.transfer(transferReq);
            accountService.saveTransferLogStatus(transferReq.getReqNo(),"success");
            return Response.success(transferResult,"请求处理完成");
        }catch (Exception exception){
            logger.error("转账异常:",exception);
            accountService.saveTransferLogStatus(transferReq.getReqNo(),"fail");
            return Response.fail("转账异常");
        }
    }

    private void validParam(TransferReq transferReq){
        // 这些if可以抽象成 责任链模式，进行校验，
        if(Objects.isNull(transferReq)){
            throw new BusinessException("501","参数校验异常");
        }
        if(StringUtils.isBlank(transferReq.getReqNo())){
            throw new BusinessException("502","无效的请求流水号");
        }
        if(StringUtils.isBlank(transferReq.getFromAccountNo())){
            throw new BusinessException("503","无效的账户号：fromAccountNo");
        }
        if(StringUtils.isBlank(transferReq.getToAccountNo())){
            throw new BusinessException("504","无效的账户号：toAccountNo");
        }
        if(Objects.isNull(transferReq.getAmount()) || BigDecimal.ZERO.compareTo(transferReq.getAmount()) >=0 ){
            throw new BusinessException("505","无效的转账金额");
        }
        // todo 当然还有其他的校验: 可能比较复杂的校验，需要调用外部系统的


    }

    private void validAccount(TransferReq transferReq){
        Account fromAccount = accountService.getAccountByNo(transferReq.getFromAccountNo());
        Account toAccount = accountService.getAccountByNo(transferReq.getToAccountNo());
        if(Objects.isNull(fromAccount) || Objects.isNull(toAccount)){
            String msg = String.format("无效的用户号:from[%s],to[%s]",transferReq.getFromAccountNo(),transferReq.getToAccountNo());
            throw new BusinessException("506",msg);
        }
        // 账户状态：正常normal，冻结freeze
        if(!StringUtils.equals("normal",fromAccount.getAccountStatus())){
            String msg = String.format("付款账户处于冻结状态，无法转账",fromAccount.getAccountNo());
            throw new BusinessException("507",msg);
        }
        if(!StringUtils.equals("normal",toAccount.getAccountStatus())){
            String msg = String.format("收款账户处于冻结状态，无法转账",toAccount.getAccountNo());
            throw new BusinessException("508",msg);
        }
    }

    private void validBalance(TransferReq transferReq){
        Account fromAccount = accountService.getAccountByNo(transferReq.getFromAccountNo());
        Account toAccount = accountService.getAccountByNo(transferReq.getToAccountNo());
        if(fromAccount.getAccountBalance().compareTo(transferReq.getAmount()) <0 ){
            String msg = String.format("付款账户余额不够，无法转账",toAccount.getAccountNo());
            throw new BusinessException("509",msg);
        }
    }

}
