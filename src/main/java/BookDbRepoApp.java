public class BookDbRepoApp {
    public static void main(String[] args) {
        BookRepository bookRepository = new DbBookRepository();

        Book book = new Book(654123,"Lens Huygh","Creating Applications while drunk.",BookType.NON_FICTION);


        //bookRepository.addBook(book);

        //bookRepository.removeBook(book);

        //System.out.println(bookRepository.getBookByIsbn(654123));
        //System.out.println(bookRepository.getBookByIsbn(65412));

        System.out.println(bookRepository.getBooksByType(BookType.FICTION));
    }
}
