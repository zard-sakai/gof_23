package Iterator.A1;

import Iterator.Sample.Aggregate;
import Iterator.Sample.Book;

import java.util.ArrayList;

public class BookShelf implements Aggregate {
    private ArrayList books;   
    public BookShelf(int initialsize) {         
        this.books = new ArrayList(initialsize);   
    }                                           
    public Iterator.Sample.Book getBookAt(int index) {
        return (Iterator.Sample.Book)books.get(index);
    }
    public void appendBook(Book book) {
        books.add(book);                        
    }
    public int getLength() {
        return books.size();                    
    }
    public Iterator.Sample.Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
