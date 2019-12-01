import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.persistence.NoResultException;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DbBookRepositoryTest {
    BookRepository bookRepository;

    @BeforeEach
    public void initBookRepository() {
        bookRepository = new DbBookRepository();
    }


    @Test
    void writeToAndReadFromCsvFile() throws FileNotFoundException {
        Book book = new Book(1, "author", "test", BookType.FICTION);
        bookRepository.addBook(book);
        assertEquals(book, bookRepository.getAllBooks().get(0));
    }

    @BeforeEach
    public void initRepository() {
        bookRepository = new SimpleBookRepository();
    }

    @Test
    public final void canAddBook() {
        bookRepository.addBook(new Book(1, "author", "test", BookType.FICTION));
    }

    @Test
    public final void canGetBookByIsbn() {
        Book book = new Book(1, "author", "title", BookType.NON_FICTION);
        bookRepository.addBook(book);
        assertEquals(book, bookRepository.getBookByIsbn(1));
    }

    @Test
    public final void canRemoveBook() {
        Book book = new Book(1, "author", "title", BookType.NON_FICTION);
        bookRepository.addBook(book);
        assertEquals(1, bookRepository.getAllBooks().size());
        bookRepository.removeBook(book);
        assertEquals(0, bookRepository.getAllBooks().size());
    }

    @Test
    public final void canGetBooksByType() {
        bookRepository.addBook(new Book(1, "author", "title", BookType.NON_FICTION));
        bookRepository.addBook(new Book(2, "author", "title", BookType.NON_FICTION));
        bookRepository.addBook(new Book(3, "author", "title", BookType.FICTION));
        assertEquals(1, bookRepository.getBooksByType(BookType.FICTION).size());
        assertEquals(2, bookRepository.getBooksByType(BookType.NON_FICTION).size());
    }

    @Test
    public final void returnNullWhenIsbnNotFound(){
        assertEquals(null,bookRepository.getBookByIsbn(0));
    }
}
