package bookstore.repository;

import bookstore.model.Book;
import bookstore.model.BookType;

import javax.persistence.*;
import java.util.List;

public abstract class DbBookRepository implements BookRepository {
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    private String persistenceUnit = null;

    public DbBookRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory(getPersistenceUnit());
        entityManager = entityManagerFactory.createEntityManager();
    }

    protected abstract String getPersistenceUnit();

    @Override
    public void addBook(Book book) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book b WHERE  b.isbn = :isbn", Book.class);
        query.setParameter("isbn", isbn);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            System.out.println("No book found with ISBN: " + isbn);
        }
        return null;
    }

    @Override
    public void removeBook(Book book) {
        Book bookToDelete = getBookByIsbn(book.getIsbn());
        if(bookToDelete != null) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(bookToDelete);
            entityTransaction.commit();
        }else{
            System.out.println("Book not present in DB: " + book);
        }
    }

    @Override
    public List<Book> getBooksByType(BookType type) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book b WHERE  b.type = :type", Book.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book", Book.class);
        return query.getResultList();
    }
}
