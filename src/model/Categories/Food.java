package model.Categories;

import model.Product;

public class Food extends Product {
    String type_food;

    public Food(String name, double price, int quantity) {
        super(name, price, quantity);
        this.type_food = type_food;
    }
}
