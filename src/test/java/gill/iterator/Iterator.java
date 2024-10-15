package gill.iterator;

public interface Iterator<E> {
    boolean hasNext();

    /**
     * 不同迭代器 迭代的方式不同，比如从前往后，从后往前都可以
     */
    E next();
}
