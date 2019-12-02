package bookstore.repository;

public class BookSupplierRepository extends DbBookRepository{

    @Override
    protected String getPersistenceUnit() {
        return "LensBookSupplier";
    }
}
