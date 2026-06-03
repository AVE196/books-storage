package ave.bookStorage.storage;

import ave.bookStorage.exceptions.ItemNotFoundException;
import ave.bookStorage.exceptions.NotAvailableCopiesException;
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

    public void takeBook(String title) throws ItemNotFoundException, NotAvailableCopiesException {
        findBookByTitle(title).removeCopy();
    }

    public void returnBook(String title) throws ItemNotFoundException {
        findBookByTitle(title).addCopy();
    }

    private Book findBookByTitle(String title) throws ItemNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) return book;
        }
        throw new ItemNotFoundException(title);
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

    public List<Book> getAllBooks() {
        return books;
    }
}
