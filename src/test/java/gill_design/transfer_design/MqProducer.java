package gill_design.transfer_design;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MqProducer {

    @Value("account.transfer.topic:demo")
    private String topic;

    private int retryTimes;

    public boolean sendAsync(Object message){

        return true;
    }

    public boolean sendSync(Object message){

        return true;
    }

}
