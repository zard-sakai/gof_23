package gill.builder;

public class Main {

    public static void main(String[] args) {
        TargetObject.Builder builder = new TargetObject.Builder();
        builder.setA("a");
        builder.setB("b");
        builder.setC("c");
        TargetObject targetObject = builder.build();
    }

}
