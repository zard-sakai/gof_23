package Strategy.A1;

import Strategy.Sample.Hand;

public interface Strategy {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}
