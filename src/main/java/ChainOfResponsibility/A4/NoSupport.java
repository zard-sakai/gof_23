package ChainOfResponsibility.A4;

import ChainOfResponsibility.Sample.Support;
import ChainOfResponsibility.Sample.Trouble;

public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }
    protected boolean resolve(Trouble trouble) {     // 解决问题的方法
        return false; // 自己什么也不处理
    }
}
