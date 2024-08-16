package Bridge.A2;

import Bridge.A3.CountDisplay;
import Bridge.A3.DisplayImpl;

import java.util.Random;

public class RandomCountDisplay extends CountDisplay {
    private Random random = new Random();
    public RandomCountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void randomDisplay(int times) {
        multiDisplay(random.nextInt(times));
    }
}
