package gill.proxy;

public class Main {

    public static void main(String[] args) {
        Target target = new Target();
        Proxy proxy = new Proxy(target);
        proxy.handle();
    }

}
