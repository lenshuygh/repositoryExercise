package bookstoreMvc;

import bookstoreMvc.service.BookStoreAppService;

public class BookStoreApp {
    public static void main(String[] args) {
        new BookStoreAppService().start();
    }
}
