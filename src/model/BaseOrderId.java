package model;

public abstract class BaseOrderId {
    private static int next_id = 1;
    private int id;

    public BaseOrderId() {
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
