package bookstore.view;

import bookstore.model.Book;
import bookstore.model.BookType;

import java.util.List;

public class StoreView implements BookView {
    @Override
    public void displayResults(List<Book> books) {
        books.forEach(System.out::println);
    }

    @Override
    public void askForIsbn() {
        System.out.print("Enter isbn #: ");
    }

    @Override
    public void askForAuthor() {
        System.out.print("Enter the name of the author: ");
    }

    @Override
    public void askForYesOrNo() {
        System.out.print("yes / no: ");
    }

    @Override
    public void askForBookType(List<BookType> bookTypes) {
        System.out.println("Booktypes:");
        bookTypes.forEach(System.out::println);
        System.out.println("Enter the type of book");
    }

    @Override
    public void displayError(String errorMessage) {
        System.out.println("Error : " + errorMessage);
    }

    @Override
    public void confirmSelling() {
        System.out.println("Confirm that the book is sold.");
        askForYesOrNo();
    }

    @Override
    public void confirmOrdering() {
        System.out.println("Confirm that the book is ordered.");
        askForYesOrNo();
    }

    public void displayMainMenu() {
        System.out.println("1.   Search book by ISBN #.");
        System.out.println("2.   Search all books by type.");
        System.out.println("3.   Search all books by author.");
        System.out.println("4.   Sell a book.");
        System.out.println("0.   Exit application");
        System.out.println("     ----------------------------");
    }

    public void getMenuChoice() {
        System.out.print("Please enter a menu choice : ");
    }
}
