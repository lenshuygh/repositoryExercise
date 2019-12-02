package bookstoreMvc.service;

import bookstoreMvc.controller.MenuController;
import bookstoreMvc.model.StoreType;

public class BookStoreAppService {
    MenuController menuController = null;

    public void start(){
        menuController = new MenuController();
    }
}
