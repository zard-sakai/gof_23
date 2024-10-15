package gill.docarate;

public class Main {

    public static void main(String[] args) {
         TargetApi target = new Target();
         target = new Decorator1(target);
         target.handle();
    }

}
