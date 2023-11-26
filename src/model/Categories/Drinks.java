package model.Categories;

import model.Product;

public class Drinks extends Product {
    private boolean contains_alcohol;

    public Drinks(String name, double price, int quantity, String expire, boolean contains_alcohol, String category) {
        super(name, price, quantity, expire, category);
        this.contains_alcohol = contains_alcohol;
    }

    @Override
    public Boolean getContainsAlcohol() {
        return contains_alcohol;
    }
}
