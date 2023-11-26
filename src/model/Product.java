package model;

public class Product extends BaseEntity {
    private String name;
    private double price;
    private String description;
    private int quantity;
    private String category;
    private String expire;

    public Product() {
    }

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(int id, String name, double price, String category) {

        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, double price, int quantity, String expire, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expire = expire;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpire() {
        return expire;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public Boolean getContainsAlcohol() {
        return null;
    }

}
