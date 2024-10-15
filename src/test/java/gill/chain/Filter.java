package gill.chain;

import java.util.Objects;

public interface Filter {

    void handle();

    void next(Filter filter);
}
