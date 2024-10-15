package gill.single;

import java.util.Objects;

public class Container5 {

    private static volatile Container5 instance;

    private Container5() {

    }

    public static Container5 getInstance() {
        if(Objects.isNull(instance)){
            synchronized (Container5.class) {
                if(Objects.isNull(instance)){
                    instance = new Container5();// 分配内存，对象初始化，地址指向
                }
                return instance;
            }
        }
        return instance;
    }
}
