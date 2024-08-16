package Bridge.A1;

import Bridge.A2.CountDisplay;
import Bridge.A2.DisplayImpl;

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
