package model;

import java.util.List;

public class Order extends BaseEntity {
    private Product product;
    private int quantity;
    private Customer customer;
    private Transaction transaction;
    private List<Product> products;

    public Order() {
    }

    public Order(Product product, int quantity, Customer customer, Transaction transaction) {
        this.product = product;
        this.quantity = quantity;
        this.customer = customer;
        this.transaction = transaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Transaction getTransaction() {
        return transaction;
    }

}
