package pl.sda.library;

import pl.sda.exception.BookIsNotAvailableException;
import pl.sda.exception.BookNotExistException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library {
    private List<Book> listOfBooks = new ArrayList<>();
    private List<User> listOfUsers = new ArrayList<>();

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public List<Book> getListOfAvailableBooks() {
        return listOfBooks
                .stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    public List<Book> getListOfUnavailableBooks() {
        return listOfBooks
                .stream()
                .filter(t -> !t.isAvailable())
                .collect(Collectors.toList());
    }

    public void addNewBook(Book b) {
        listOfBooks.add(b);
    }

    public void removeBook(Book book) {
        Optional<Book> b = listOfBooks
                .stream()
                .filter(tmp -> tmp.equals(book))
                .findFirst();

        if (b.isPresent())
            listOfBooks.remove(b.get());
        else
            System.out.println("Nie ma takiej ksiazki");
        //listOfBooks.remove(book); //working too
    }

    public Book findOldestBook() {
        return listOfBooks
                .stream()
                .min(Comparator.comparingInt(Book::getYearOfPublish))
                .get();
    }

    public Book findNewestBook() {
        return listOfBooks
                .stream()
                .max(Comparator.comparingInt(Book::getYearOfPublish))
                .get();
    }

    public Book findLongestBook() {
        return listOfBooks
                .stream()
                .max(Comparator.comparingInt(Book::getNumberOfPages))
                .get();
    }

    public Book findShortestBook() {
        return listOfBooks
                .stream()
                .min(Comparator.comparingInt(Book::getNumberOfPages))
                .get();
    }

    public boolean lendBookToUser(Book book, User user) throws BookIsNotAvailableException, BookNotExistException {
        if (!book.isAvailable())
            throw new BookIsNotAvailableException();
        else if (user.getListOfBorrowedBooks().size() >= 3) {
            System.out.println("Too many books borrowed!");
            return false;
        } else {
            user.borrowBook(book);
            book.setAvailable(false);
            return true;
        }
    }

    public void addNewUser(String name, String address) {
        listOfUsers.add(new User(name, address));
    }

    public List<Book> findBook(String tile) {
        return listOfBooks
                .stream()
                .filter(b -> b.getTitle().toLowerCase().contains(tile.toLowerCase()))
                .collect(Collectors.toList());

    }

    public void printListOfBooks(List<Book> list) {
        list.forEach(b -> System.out.println(b.getFullInformation()));
    }
}
