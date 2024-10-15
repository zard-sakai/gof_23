package gill.docarate;

public class Target implements TargetApi{

    @Override
    public void handle() {
        System.out.println("Target handle");
    }
}
