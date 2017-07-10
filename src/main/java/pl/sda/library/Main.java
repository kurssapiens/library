package pl.sda.library;

import pl.sda.exception.BookIsNotAvailableException;
import pl.sda.exception.BookNotExistException;

public class Main {
    public static void main(String[] args) {

        Library mainLibrary = new Library();
        Book b1 = new Book("Java. Podstawy", "Cay Horstmann", 2015, 968, 1234, true);
        Book b2 = new Book("C++ dla zaawansowanych", "Jerzy Grebosz", 1998, 1125, 4536, true);
        Book b3 = new Book("Zbrodnia i kara", "Fiodor Dostojewski", 1896, 562, 5324, true);
        Book b4 = new Book("Zew Cthulu", "Howard Phillips Lovecraft", 1940, 346, 1244, true);
        Book b5 = new Book("Pan Tadeusz", "Adam Mickiewicz", 1756, 346, 1474, true);

        mainLibrary.addNewBook(b1);
        mainLibrary.addNewBook(b2);
        mainLibrary.addNewBook(b3);
        mainLibrary.addNewBook(b4);
        mainLibrary.addNewBook(b5);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("                      LISTA KSIAZEK:                               ");
        System.out.println("-------------------------------------------------------------------");
        mainLibrary.printListOfBooks(mainLibrary.getListOfBooks());

        System.out.println();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("                      WYSZUKIWANIE :                               ");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Najstarsza: ");
        System.out.println(mainLibrary.findOldestBook().getFullInformation());
        System.out.print("Najnowsza: ");
        System.out.println(mainLibrary.findNewestBook().getFullInformation());
        System.out.print("Najdluzsza: ");
        System.out.println(mainLibrary.findLongestBook().getFullInformation());
        System.out.print("Najkrotsza: ");
        System.out.println(mainLibrary.findShortestBook().getFullInformation());

        System.out.println();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("                  LISTA DOSTEPNYCH KSIAZEK:                        ");
        System.out.println("-------------------------------------------------------------------");
        mainLibrary.printListOfBooks(mainLibrary.getListOfAvailableBooks());

        System.out.println();

        mainLibrary.addNewUser("Adam Mielcarz", "ul. Kwiatowa 33, 42-200 Czestochowa");

        try {
            mainLibrary.lendBookToUser(b1, mainLibrary.getListOfUsers().get(0));
            mainLibrary.lendBookToUser(b3, mainLibrary.getListOfUsers().get(0));
            mainLibrary.lendBookToUser(b4, mainLibrary.getListOfUsers().get(0));
            mainLibrary.lendBookToUser(b5, mainLibrary.getListOfUsers().get(0));
        } catch (BookIsNotAvailableException | BookNotExistException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("                  LISTA NIEDOSTEPNYCH KSIAZEK:                     ");
        System.out.println("-------------------------------------------------------------------");
        mainLibrary.printListOfBooks(mainLibrary.getListOfUnavailableBooks());

        System.out.println();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("                      LISTA KSIAZEK:                               ");
        System.out.println("-------------------------------------------------------------------");
        mainLibrary.printListOfBooks(mainLibrary.getListOfBooks());

        System.out.println();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("                  LISTA KSIAZEK UZYTKOWNIKA 1:                     ");
        System.out.println("-------------------------------------------------------------------");
        mainLibrary.printListOfBooks(mainLibrary.getListOfUsers().get(0).getListOfBorrowedBooks());

        System.out.println();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("                WYSZUKIWANIE KSIAZEK PO NAZWIE                     ");
        System.out.println("-------------------------------------------------------------------");
        mainLibrary.printListOfBooks(mainLibrary.findBook("kara"));
        mainLibrary.printListOfBooks(mainLibrary.findBook("cthu"));
    }
}
