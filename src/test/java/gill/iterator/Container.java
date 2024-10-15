package gill.iterator;

public interface Container<E> {

    Iterator<E> iterator();

    void add(E element);

    void delete(E element);
}
