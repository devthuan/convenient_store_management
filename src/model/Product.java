package model;

import java.time.LocalDate;

public abstract class Product {
    private static int next_id = 1;
    private int id;
    private String name;
    private double price;
    private String description;
    private int quantity;
    private String category;
    private LocalDate expire;

    public Product() {
    }

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(int id, String name, double price, String category) {
        this.id = next_id++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, double price, int quantity, LocalDate expire, String category) {
        this.id = next_id++;
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

    public int getId() {
        return id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpire() {
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

    public void setExpire(LocalDate expire) {
        this.expire = expire;
    }

    public static void resetId() {
        next_id = 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract Boolean getContainsAlcohol();

}
