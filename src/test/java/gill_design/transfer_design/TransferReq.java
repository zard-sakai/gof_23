package gill_design.transfer_design;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferReq {

    private String reqNo;
    private String fromAccountNo;
    private String toAccountNo;
    private BigDecimal amount;
}
