package Strategy.A1;

import Strategy.Sample.Hand;

import java.util.Random;

public class RandomStrategy implements Strategy.Sample.Strategy {
    private Random random;
    public RandomStrategy(int seed) {
        random = new Random(seed);
    }
    public void study(boolean win) {
    }
    public Strategy.Sample.Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }
}
