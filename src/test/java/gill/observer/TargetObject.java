package gill.observer;

import java.util.ArrayList;
import java.util.List;

public class TargetObject {

    private List<Observer> observers;

    public TargetObject() {
        observers = new ArrayList<>();
    }

    public void notifyObservers() {
        observers.stream().forEach(observer -> {
            observer.handle();
        });
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

}
