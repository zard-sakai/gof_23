package gill.single;

public class Container {

    private static Container instance = new Container();

    private Container(){
    }

    public static Container getInstance(){
        return instance;
    }

}
