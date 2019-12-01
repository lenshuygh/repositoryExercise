import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleBookRepository implements BookRepository {
    List<Book> books = new ArrayList<>();
    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getIsbn() == isbn){
                return books.get(i);
            }
        }
        return null;
    }

    @Override
    public void removeBook(Book book) {
        //books.contains(book)
        books.remove(book);
    }

    @Override
    public List<Book> getBooksByType(BookType type) {
        return books.stream().filter(b -> b.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}
