package gill.proxy;

public class Proxy implements Handle{

    private Target target;

    public Proxy(Target target){
        this.target = target;
    }

    @Override
    public void handle() {
        target.handle();
    }
}
