package gill.adapter;

public class Processor {
    private OldInterface oldInterface;

    public Processor(OldInterface oldInterface) {
        this.oldInterface = oldInterface;
    }

    public void handle(){
        oldInterface.handle();
    }
}
