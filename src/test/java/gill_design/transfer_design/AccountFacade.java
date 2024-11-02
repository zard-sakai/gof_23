package gill_design.transfer_design;

import org.apache.dubbo.config.annotation.DubboService;

import java.math.BigDecimal;

public interface AccountFacade {

    Response transfer(TransferReq transferReq);
}
