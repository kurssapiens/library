package pl.sda.library;

public class Book {
    private String title, author;
    private int yearOfPublish, numberOfPages, index;
    private boolean available;

    Book() {

    }

    public Book(String title, String author, int yearOfPublish, int numberOfPages, int index, boolean available) {
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.numberOfPages = numberOfPages;
        this.index = index;
        this.available = available;
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

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getFullInformation() {
        return index + "   |   " + title + "   |   " + author + "   |   " + yearOfPublish + "   |   str: " + numberOfPages + "   |   " + available;
    }
}
