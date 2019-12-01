import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CsvBookRepositoryTest {
    BookRepository bookRepository;

    @BeforeEach
    public void initBookRepository() {
        bookRepository = new CsvBookRepository("testBooks.csv");
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
}