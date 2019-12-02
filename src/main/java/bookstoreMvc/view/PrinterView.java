package bookstoreMvc.view;

import bookstoreMvc.model.StoreType;

public class PrinterView {
    public void displayMainMenu(StoreType storeType) {
            switch (storeType) {
                case STORE:
                    System.out.println("1.  Search by ISBN");
                    System.out.println("2.  Search by type");
                    System.out.println("3.  Search by author");
                    System.out.println("4.  Sell a book");
                    System.out.println("0.  Return to previous menu");
                    break;
                case SUPPLIER:
                    System.out.println("1.  Search by ISBN");
                    System.out.println("2.  Order a book");
                    System.out.println("0.  Return to previous menu");
                    break;
                case MAIN:
                    System.out.println("1.  BookStore");
                    System.out.println("2.  BookSupplier");
                    System.out.println("0.  Exit Program");
                    break;
            }
    }

        public void displayAskMenuChoice (StoreType storeType){
            System.out.print("Enter menu option: (0-" + storeType.maxMenuChoice + "): ");
        }
    }
