package pl.sda.library;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name, address;
    private List<Book> listOfBorrowedBooks = new ArrayList<>();

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getListOfBorrowedBooks() {
        return listOfBorrowedBooks;
    }

    public void setListOfBorrowedBooks(List<Book> listOfBorrowedBooks) {
        this.listOfBorrowedBooks = listOfBorrowedBooks;
    }

    public void borrowBook(Book b) {
        listOfBorrowedBooks.add(b);
    }

    public void returnBook(Book b) {
        listOfBorrowedBooks.remove(b);
    }
}
