package bookstore.controller;

import bookstore.model.Book;
import bookstore.model.BookType;

import java.util.List;

public interface BookStoreController {
    public Book getBookByIsbn(int isbn);

    public List<Book> getBooksByType(BookType bookType);

    public List<Book> getBooksByAuthor(String author);

}
