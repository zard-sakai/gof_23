package gill.docarate;

public class Decorator1 implements TargetApi{

    private TargetApi target;

    public Decorator1(TargetApi target) {
        this.target = target;
    }

    @Override
    public void handle() {
        decorate();
        target.handle();
    }

    private void decorate(){
        System.out.println("Decorator1");
    }
}
