package Iterator.A1;

import Iterator.Sample.Book;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Iterator.Sample.Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Iterator.Sample.Book("Bible"));
        bookShelf.appendBook(new Iterator.Sample.Book("Cinderella"));
        bookShelf.appendBook(new Iterator.Sample.Book("Daddy-Long-Legs"));
        bookShelf.appendBook(new Iterator.Sample.Book("East of Eden"));
        bookShelf.appendBook(new Iterator.Sample.Book("Frankenstein"));
        bookShelf.appendBook(new Iterator.Sample.Book("Gulliver's Travels"));
        bookShelf.appendBook(new Iterator.Sample.Book("Hamlet"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Iterator.Sample.Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
