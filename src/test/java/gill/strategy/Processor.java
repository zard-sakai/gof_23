package gill.strategy;

public class Processor {

    private Strategy strategy;

    public Processor(Strategy strategy) {
        this.strategy = strategy;
    }

    public void process(){
        strategy.method1();
        strategy.method2();
        strategy.method3();
    }

}
