package gill_design.transfer_design;

/**
 * 补偿 扣款成功，收款一直不成功的情况
 */
public class FailedReceiptTransferCompensationScheduler {

    public void handle(){
        // 获取 MqConsumer 记录的日志
        // 调用AccountMapper.addAmount 处理收款
    }

}
