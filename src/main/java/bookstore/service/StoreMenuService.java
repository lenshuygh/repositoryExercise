package bookstore.service;

import bookstore.view.StoreView;

public class StoreMenuService implements MenuServiceInterface {
    private int menuChoiceMin = 1;
    private int menuChoiceMax = 4;

    StoreView storeView = new StoreView();
    @Override
    public void displayMenu() {
        storeView.displayMainMenu();
    }

    @Override
    public void getMenuChoice() {
        storeView.getMenuChoice();

    }
}
