package gill_design.transfer_design;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Long id;
    private String accountNo;
    private String accountStatus;
    private BigDecimal accountBalance;

    private Long version;

}
