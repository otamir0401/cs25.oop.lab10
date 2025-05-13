package Dasgal2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    class BookShelf implements Iterable<Book> {
        private List<Book> books = new ArrayList<>();
        private int minYear;

        public BookShelf(int minYear) {
            this.minYear = minYear;
        }

        public void addBook(Book book) {
            books.add(book);
        }

        @Override
        public Iterator<Book> iterator() {
            return books.stream()
                        .filter(b -> b.getYear() >= minYear)
                        .iterator();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Library lib = new Library();
        Library.BookShelf shelf = lib.new BookShelf(2000);

        shelf.addBook(new Book("Сүүн Зам", 2020));
        shelf.addBook(new Book("Морьтой хүн", 1990));

        for (Book b : shelf) {
            System.out.println(b);
        }
    }
}
