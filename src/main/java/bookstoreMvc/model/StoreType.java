package bookstoreMvc.model;

public enum StoreType {
    MAIN(2),STORE(4), SUPPLIER(2);

    public final int maxMenuChoice;

    StoreType(int maxMenuChoice) {
        this.maxMenuChoice = maxMenuChoice;
    }
}
