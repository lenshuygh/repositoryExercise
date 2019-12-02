package bookstore.controller;

import bookstore.model.BookType;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInputController {
    private Scanner scanner;
    private List<BookType> bookTypeList;

    public UserInputController() {
        bookTypeList = Arrays.stream(BookType.values()).collect(Collectors.toList());
    }

    public int getInt() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String getString() {
        scanner = new Scanner(System.in);
        return scanner.next();
    }

    public boolean getBoolean() {
        scanner = new Scanner(System.in);
        String yesNoString = getString();
        return yesNoString.toUpperCase().equals("YES") ? true : false;
    }
}
