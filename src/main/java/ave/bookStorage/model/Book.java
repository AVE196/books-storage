package ave.bookStorage.model;

import ave.bookStorage.exceptions.ItemNotFoundException;
import ave.bookStorage.exceptions.NotAvailableCopiesException;

public class Book {

    private String author;

    private String title;

    private int availableCopies;

    public Book (String author, String title, int availableCopies) {
        this.author = author;
        this.title = title;
        this.availableCopies = availableCopies;
    }

    public void addCopy() {
        availableCopies++;
    }

    public void removeCopy() throws NotAvailableCopiesException {
        if (availableCopies == 0)
            throw new NotAvailableCopiesException(author + ", " + title);
        availableCopies--;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Автор: " + author + ", название книги: " + title + ", доступное количество копий: " + availableCopies;
    }

}
