package model.Categories;

import java.time.LocalDate;

import model.Product;

public class Food extends Product {
    String type_food;

    public Food(String name, double price, int quantity, LocalDate expire, String category) {
        super(name, price, quantity, expire, category);

    }

    @Override
    public Boolean getContainsAlcohol() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContainsAlcohol'");
    }

}
