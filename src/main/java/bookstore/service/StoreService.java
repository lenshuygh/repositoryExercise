package bookstore.service;

import bookstore.controller.StoreController;
import bookstore.view.StoreView;

public class StoreService {
    private AskAndReplyService askAndReplyService = new AskAndReplyService();
    private StoreView storeView = new StoreView();
    private StoreController storeController = new StoreController();

    public void askAndDisplayFromIsbn(){
        storeController.getBookByIsbn(askAndReplyService.getIsbn());
    }

    public void askAndDisplayFromType(){
        storeController.getBooksByType(askAndReplyService.getBookType());
    }

    public void askAndDisplayFromAuthor(){
        storeController.getBooksByAuthor(askAndReplyService.getAuthor());
    }

    public void askForBookSale(){
        askAndReplyService.getConfirmSelling();
    }
}
