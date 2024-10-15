package gill.chain;

import java.util.Objects;

public class Filter2 implements Filter{

    private Filter next;

    public Filter2(){

    }

    @Override
    public void next(Filter filter){
        next = filter;
    }

    @Override
    public void handle(){
        System.out.println("filter2 process");
        if(Objects.nonNull(next)){
            next.handle();
        }
    }

}
