package gill.docarate;

public class Decorator2 implements TargetApi{

    private TargetApi target;

    public Decorator2(TargetApi target) {
        this.target = target;
    }

    @Override
    public void handle() {
        decorate();
        target.handle();
    }

    private void decorate(){
        System.out.println("Decorator2");
    }
}
