package gill.builder;

public class TargetObject {

    private TargetObject() {

    }

    private String a;
    private String b;
    private String c;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    private void setA(String a) {
        this.a = a;
    }

    private void setB(String b) {
        this.b = b;
    }

    private void setC(String c) {
        this.c = c;
    }

    static class Builder {

        private TargetObject targetObject;

        public Builder(){
            this.targetObject = new TargetObject();
        }

        public void setA(String a) {
            targetObject.setA(a);
        }

        public void setB(String b) {
            targetObject.setB(b);
        }

        public void setC(String c) {
            targetObject.setC(c);
        }

        public TargetObject build(){
            return targetObject;
        }

    }
}
