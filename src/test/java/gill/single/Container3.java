package gill.single;

import java.util.Objects;

public class Container3 {

    private static Container3 instance;

    private Container3() {

    }

    public static synchronized Container3 getInstance() {
        if(Objects.isNull(instance)){
            instance = new Container3();
        }
        return instance;
    }
}
