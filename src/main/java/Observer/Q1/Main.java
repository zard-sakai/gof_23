package Observer.Q1;

import Observer.Sample.DigitObserver;
import Observer.Sample.GraphObserver;
import Observer.Sample.NumberGenerator;
import Observer.Sample.Observer;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new IncrementalNumberGenerator(10, 50, 5);
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
