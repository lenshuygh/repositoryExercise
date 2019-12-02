package bookstore.service;

import bookstore.controller.UserInputController;
import bookstore.model.BookType;
import bookstore.view.StoreView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AskAndReplyService {
    private StoreView storeView = new StoreView();
    private UserInputController userInputController = new UserInputController();
    private List<BookType> bookTypeList;

    public AskAndReplyService() {
        bookTypeList = Arrays.stream(BookType.values()).collect(Collectors.toList());
    }

    public int getIsbn(){
        storeView.askForIsbn();
        return userInputController.getInt();
    }

    public String getAuthor(){
        storeView.askForAuthor();
        return userInputController.getString();
    }

    public boolean getConfirmYesNo(){
        storeView.askForYesOrNo();
        return userInputController.getBoolean();
    }

    public BookType getBookType(){
        storeView.askForBookType(bookTypeList);
        return BookType.valueOf(userInputController.getString());
    }

    public boolean getConfirmSelling(){
        storeView.confirmSelling();
        return getConfirmYesNo();
    }

    public boolean getConfirmOrdering(){
        storeView.confirmOrdering();
        return getConfirmYesNo();
    }
}
