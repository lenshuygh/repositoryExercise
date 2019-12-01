import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvBookRepository extends SimpleBookRepository {
    private final String pathAndFileName;
    private CsvHandler csvHandler;

    public CsvBookRepository(String pathAndFileName) {
        csvHandler = new OpenCsvHandler(pathAndFileName);
        this.pathAndFileName = pathAndFileName;
    }

    @Override
    public void addBook(Book book) {
        super.addBook(book);
        csvHandler.writeToCsvFile(books);
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        books = csvHandler.readFromCsv();
        return super.getBookByIsbn(isbn);
    }

    @Override
    public void removeBook(Book book) {
        super.removeBook(book);
        csvHandler.writeToCsvFile(books);
    }

    @Override
    public List<Book> getBooksByType(BookType type) {
        books = csvHandler.readFromCsv();
        return super.getBooksByType(type);
    }

    @Override
    public List<Book> getAllBooks() {
        books = csvHandler.readFromCsv();
        return super.getAllBooks();
    }
}
