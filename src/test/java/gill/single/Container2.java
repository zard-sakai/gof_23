package gill.single;

import java.util.Objects;

public class Container2 {

    private static Container2 instance;

    private Container2() {

    }

    public static Container2 getInstance() {
        if(Objects.isNull(instance)){
            instance = new Container2();
        }
        return instance;
    }
}
