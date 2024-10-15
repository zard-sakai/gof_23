package gill.chain;

import java.util.Objects;

public class Filter1 implements Filter{

    private Filter next;

    public Filter1(){

    }

    @Override
    public void next(Filter filter){
        next = filter;
    }

    @Override
    public void handle(){
        System.out.println("filter1 process");
        if(Objects.nonNull(next)){
            next.handle();
        }
    }

}
