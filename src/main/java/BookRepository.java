import java.util.List;

public interface BookRepository {
    void addBook(Book book);

    Book getBookByIsbn(int isbn);

    void removeBook(Book book);

    List<Book> getBooksByType(BookType type);

    List<Book> getAllBooks();

}
