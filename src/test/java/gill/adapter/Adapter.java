package gill.adapter;

public class Adapter implements OldInterface{

    private NewInterface instance;

    @Override
    public void handle() {
        this.instance.process();
    }

    public Adapter(NewInterface newInterface){
        this.instance = newInterface;
    }
}
