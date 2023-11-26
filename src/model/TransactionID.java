package model;

public abstract class TransactionID {
    private static int next_id = 1;
    private int id;

    public TransactionID() {
        this.id = next_id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void resetId() {
        next_id = 1;
    }
}
