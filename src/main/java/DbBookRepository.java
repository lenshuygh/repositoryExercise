import javax.persistence.*;
import java.util.List;

public class DbBookRepository implements BookRepository {
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;

    public DbBookRepository() {
            entityManagerFactory = Persistence.createEntityManagerFactory("books");
            entityManager = entityManagerFactory.createEntityManager();

    }

    @Override
    public void addBook(Book book) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book b WHERE  b.isbn = :isbn",Book.class);
        query.setParameter("isbn",isbn);
        return query.getSingleResult();
    }

    @Override
    public void removeBook(Book book) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(book);
        entityTransaction.commit();
    }

    @Override
    public List<Book> getBooksByType(BookType type) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book b WHERE  b.type = :type",Book.class);
        query.setParameter("type",type);
        return query.getResultList();
    }

    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book",Book.class);
        return query.getResultList();
    }
}
