package gill_design.transfer_design;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountLog {

    private Long id;
    private String requestNo;//requestNo
    private String fromAccountNo;
    private String toAccountNo;
    private BigDecimal amount;
    private String status;// init待处理 success处理成功 fail处理失败


}
