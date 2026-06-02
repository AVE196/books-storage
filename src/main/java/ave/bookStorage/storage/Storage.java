package ave.bookStorage.storage;

import ave.bookStorage.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private final List<Book> books;

    public Storage() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void takeBook() {

    }

    public void returnBook() {

    }

    public void printBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста");
        } else {
            for (int i = 0; i < books.size(); i++ ) {
                System.out.println(i + 1 + " - " + books.get(i));
            }
        }
    }
}
