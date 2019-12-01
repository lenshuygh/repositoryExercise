import java.util.List;

public interface CsvHandler {
    void writeToCsvFile(List<Book> books);
    List<Book> readFromCsv();
}
