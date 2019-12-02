package bookstore.view;

import bookstore.model.Book;
import bookstore.model.BookType;

import java.util.List;

public interface BookView {
    void displayResults(List<Book> books);
    void askForIsbn();
    void askForAuthor();
    void askForYesOrNo();
    void askForBookType(List<BookType> bookTypes);
    void displayError(String errorMessage);
    void confirmSelling();
    void confirmOrdering();
}
