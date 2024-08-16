package Observer.A1;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();        // 保存Observer们
    public void addObserver(Observer.A2.Observer observer) {    // 注册Observer
        observers.add(observer);
    }
    public void deleteObserver(Observer.A2.Observer observer) { // 删除Observer
        observers.remove(observer);
    }
    public void notifyObservers() {               // 向Observer发送通知
        Iterator it = observers.iterator();
        while (it.hasNext()) {
            Observer.A2.Observer o = (Observer.A2.Observer)it.next();
            o.update(this);
        }
    }
    public abstract int getNumber();                // 获取数值
    public abstract void execute();                 // 生成数值
}
