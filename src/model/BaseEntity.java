package model;

public abstract class BaseEntity {
    private static int next_id = 1;
    private int id;

    public BaseEntity() {
        this.id = next_id++;
    }

    public int getId(){
        return id;
    }
}
