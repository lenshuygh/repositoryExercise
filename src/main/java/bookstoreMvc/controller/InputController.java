package bookstoreMvc.controller;

import bookstoreMvc.exception.InvalidEntryTypeException;
import bookstoreMvc.model.StoreType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputController {
    Scanner scanner;

    private String getInput() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getMenuChoice(StoreType storeType) {
        final String inputString = getInput();
        try {
                int menuChoiceInt = Integer.parseInt(inputString);
            if (menuChoiceInt >= 0 && menuChoiceInt <= storeType.maxMenuChoice) {
                return menuChoiceInt;
            }else{
                System.out.println("Please inter a number between 0 and " + storeType.maxMenuChoice);
                getMenuChoice(storeType);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter a number in stead of " + inputString);
            getMenuChoice(storeType);
        }
        return -1;
    }
}
