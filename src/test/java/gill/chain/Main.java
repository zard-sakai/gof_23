package gill.chain;

public class Main {

    public static void main(String[] args) {
        Filter filter1 = new Filter1();
        Filter filter2 = new Filter2();
        filter2.next(filter1);
        filter2.handle();
    }

}
