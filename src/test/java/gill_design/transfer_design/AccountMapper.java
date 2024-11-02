package gill_design.transfer_design;

import java.math.BigDecimal;

public interface AccountMapper {

    /**
     * select * from account where account_no = #{accountNo}
     */
    Account selectByAccountNo(String accountNo);

    /**
     * update account set  account_balance = account_balance - #{amount},version =  #{account.version} + 1
     * where account_no = #{account.accountNo} and version = #{account.version}
     * 比较更新行数，行数 > 0 则为 true
     */
    boolean deductAmount(Account account, BigDecimal amount);


    /**
     * update account set  account_balance = account_balance + #{amount},version =  #{account.version} + 1
     * where account_no = #{account.accountNo} and version = #{account.version}
     * 比较更新行数，行数 > 0 则为 true
     */
    boolean addAmount(Account account, BigDecimal amount);
}
