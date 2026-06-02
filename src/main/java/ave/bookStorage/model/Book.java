package ave.bookStorage.model;

public class Book {

    private String author;

    private String title;

    private int availableCopies;

    public Book (String author, String title, int availableCopies) {
        this.author = author;
        this.title = title;
        this.availableCopies = availableCopies;
    }

    public void addCopies(int numberCopies) {
        availableCopies += numberCopies;
    }

    public void giveCopies(int numberCopies) {
        availableCopies -= numberCopies;
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
