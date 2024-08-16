package Iterator.gill;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {
    private List<Book> books;
    public BookShelf(int initialSize) {
        this.books = new ArrayList<>(initialSize);
    }
    public Book getBookAt(int index) {
        return books.get(index);
    }
    public void appendBook(Book book) {
        books.add(book);
    }
    public int getLength() {
        return books.size();
    }
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}