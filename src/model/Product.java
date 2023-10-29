package model;

public class Product extends BaseEntity {
    private int product_id;
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
