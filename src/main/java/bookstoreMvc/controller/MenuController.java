package bookstoreMvc.controller;

import bookstoreMvc.model.StoreType;
import bookstoreMvc.view.PrinterView;

public class MenuController {
    private PrinterView printerView;
    private InputController inputController;
    private static final int PROGRAM_SHUTDOWN = -1;
    private static final int EXIT_MENU = 0;
    private StoreController storeController;
    private SupplierController supplierController;

    public MenuController() {
        printerView = new PrinterView();
        inputController = new InputController();
        storeController = new StoreController();
        supplierController = new SupplierController();
        startMenu(StoreType.MAIN);
    }

    private void startMenu(StoreType storeType) {
        int menuChoice = EXIT_MENU;
        while (menuChoice != PROGRAM_SHUTDOWN) {
            printerView.displayMainMenu(storeType);
            printerView.displayAskMenuChoice(storeType);
            menuChoice = inputController.getMenuChoice(storeType);
            if (storeType == StoreType.MAIN) {
                switch (menuChoice) {
                    case 0:
                        menuChoice = PROGRAM_SHUTDOWN;
                        break;
                    case 1:
                        storeType = StoreType.STORE;
                        break;
                    case 2:
                        storeType = StoreType.SUPPLIER;
                        break;
                }
            }else{
                if(menuChoice == EXIT_MENU){
                    storeType = StoreType.MAIN;
                }else{
                    performSubMenu(menuChoice,storeType);
                }
            }
        }
    }

    private void performSubMenu(int menuChoice, StoreType storeType) {
        switch (storeType) {
            case STORE:
                storeController.performMenuOption(menuChoice);
                break;
            case SUPPLIER:
                supplierController.performMenuOption(menuChoice);
                break;
        }
    }
}
