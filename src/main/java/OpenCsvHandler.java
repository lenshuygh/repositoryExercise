import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OpenCsvHandler implements CsvHandler {
    private final static int ISBN_INDEX = 0;
    private final static int AUTHOR_INDEX = 1;
    private final static int TITLE_INDEX = 2;
    private final static int TYPE_INDEX = 3;
    private String fileNameAndPath;

    public OpenCsvHandler(String fileNameAndPath) {
        this.fileNameAndPath = fileNameAndPath;
    }

    @Override
    public void writeToCsvFile(List<Book> books) {
        File csvOutputFile = new File(fileNameAndPath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            books.stream().map(Book::toString).forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> readFromCsv() {
        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fileNameAndPath));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return records.stream().map(this::convertBookDataAsStreamToBookObject).collect(Collectors.toList());
    }

    private Book convertBookDataAsStreamToBookObject(List<String> strings) {
        Book book = new Book(
                Integer.parseInt(strings.get(ISBN_INDEX)),
                strings.get(AUTHOR_INDEX),
                strings.get(TITLE_INDEX),
                (BookType.valueOf(strings.get(TYPE_INDEX)))
        );
        return book;
    }
}
