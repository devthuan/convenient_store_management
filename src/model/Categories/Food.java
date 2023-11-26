package model.Categories;

import model.Product;

public class Food extends Product {
    String type_food;
    String expire;

    public Food(String name, double price, int quantity, String expire, String category) {
        super(name, price, quantity, expire, category);
        
    }

    @Override
    public String getExpire() {
        return expire;
    }
}
