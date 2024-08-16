package Observer.A2;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();        // 保存Observer们
    public void addObserver(Observer.Sample.Observer observer) {    // 注册Observer
        observers.add(observer);
    }
    public void deleteObserver(Observer.Sample.Observer observer) { // 删除Observer
        observers.remove(observer);
    }
    public void notifyObservers() {               // 向Observer发送通知
        Iterator it = observers.iterator();
        while (it.hasNext()) {
            Observer.Sample.Observer o = (Observer.Sample.Observer)it.next();
            o.update(this);
        }
    }
    public abstract int getNumber();                // 获取数值
    public abstract void execute();                 // 生成数值
}
