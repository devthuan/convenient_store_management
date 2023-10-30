package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Product;
import ui.ProductUI;

public class ProductManager implements InterfaceCRUD {
    static List<Product> products = new ArrayList<>();

    public static void startProductManager(Scanner scanner) {
        ProductUI.handleProduct(scanner, products);
    }

    @Override
    public void create(Object entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Object read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void update(Object entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Object search(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
}
