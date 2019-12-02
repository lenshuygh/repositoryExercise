package bookstore.controller;

import bookstore.model.Book;
import bookstore.model.BookType;
import bookstore.repository.BookStoreRepository;
import bookstore.repository.DbBookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StoreController implements BookStoreController {
    private DbBookRepository dbBookRepository = new BookStoreRepository();

    @Override
    public Book getBookByIsbn(int isbn) {
        return dbBookRepository.getBookByIsbn(isbn);
    }

    @Override
    public List<Book> getBooksByType(BookType bookType) {
        return dbBookRepository.getBooksByType(bookType);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return dbBookRepository.getAllBooks().stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }
}
