package gill.single;

import java.util.Objects;

public class Container4 {

    private static Container4 instance;

    private Container4() {

    }

    public static Container4 getInstance() {
        if(Objects.isNull(instance)){
            synchronized (Container4.class) {
                if(Objects.isNull(instance)){
                    instance = new Container4();
                }
                return instance;
            }
        }
        return instance;
    }
}
