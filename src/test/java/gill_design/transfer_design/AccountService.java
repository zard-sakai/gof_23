package gill_design.transfer_design;

public interface AccountService {

    boolean transfer(TransferReq transferReq);

    Account getAccountByNo(String accountNo);

    TransferLog getTransferLog(String requestNo);

    void saveTransferLogStatus(String requestNo,String status);

    AccountLog getAccountLog(String requestNo,String accountNo);

    boolean saveAccountLog(TransferReq transferReq,String status);

    void saveAllLog(TransferReq transferReq,String status);
}
