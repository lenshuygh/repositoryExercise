package bookstore.repository;

public class BookStoreRepository extends DbBookRepository {
    @Override
    protected String getPersistenceUnit() {
        return "LensBookStore";
    }
}
