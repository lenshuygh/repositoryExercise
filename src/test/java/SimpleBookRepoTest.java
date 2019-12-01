import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBookRepoTest {
    BookRepository simpleBookRepository;

    @BeforeEach
    public void initRepository(){
        simpleBookRepository = new SimpleBookRepository();
    }

    @Test
    public final void canAddBook(){
        simpleBookRepository.addBook(new Book(1,"author","test",BookType.FICTION));
    }

    @Test
    public final void canGetBookByIsbn(){
        Book book = new Book(1,"author","title",BookType.NON_FICTION);
        simpleBookRepository.addBook(book);
        assertEquals(book,simpleBookRepository.getBookByIsbn(1));
    }

    @Test
    public final void canRemoveBook(){
        Book book = new Book(1,"author","title",BookType.NON_FICTION);
        simpleBookRepository.addBook(book);
        assertEquals(1,simpleBookRepository.getAllBooks().size());
        simpleBookRepository.removeBook(book);
        assertEquals(0,simpleBookRepository.getAllBooks().size());
    }

    @Test
    public final void canGetBooksByType(){
        simpleBookRepository.addBook(new Book(1,"author","title",BookType.NON_FICTION));
        simpleBookRepository.addBook(new Book(2,"author","title",BookType.NON_FICTION));
        simpleBookRepository.addBook(new Book(3,"author","title",BookType.FICTION));
        assertEquals(1,simpleBookRepository.getBooksByType(BookType.FICTION).size());
        assertEquals(2,simpleBookRepository.getBooksByType(BookType.NON_FICTION).size());
    }

}
