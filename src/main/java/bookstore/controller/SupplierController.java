package bookstore.controller;

import bookstore.model.Book;
import bookstore.repository.BookSupplierRepository;
import bookstore.model.BookType;
import bookstore.repository.DbBookRepository;

import java.util.List;

public class SupplierController implements BookStoreController {
    private DbBookRepository dbBookRepository = new BookSupplierRepository();

    @Override
    public Book getBookByIsbn(int isbn) {
        return dbBookRepository.getBookByIsbn(isbn);
    }

    @Override
    public List<Book> getBooksByType(BookType bookType) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return null;
    }
}
