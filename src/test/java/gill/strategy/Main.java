package gill.strategy;

public class Main {

    public static void main(String[] args) {
        Strategy strategy = new Strategy1();
        Processor processor = new Processor(strategy);
        processor.process();
    }

}
