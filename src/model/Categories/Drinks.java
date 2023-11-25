package model.Categories;

import model.Product;

public class Drinks extends Product {
    String type_drink;

    public Drinks(String name, double price, int quantity) {
        super(name, price, quantity);
        this.type_drink = type_drink;
    }
}
