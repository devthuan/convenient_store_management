package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Order extends BaseEntity {
    private Product product;
    private List<Product> products;
    private Customer customer;
    private Employee employee;
    private Transaction transaction;
    private LocalDate order_date;

    public Order() {
    }

    public Order(List<Product> products, LocalDate order_date, Customer customer, Employee employee,
            Transaction transaction) {
        this.customer = customer;
        this.employee = employee;
        this.products = products;
        this.transaction = transaction;
        this.order_date = order_date;
    }

    public Order(Product product, LocalDate order_date, Customer customer, Transaction transaction) {
        this.customer = customer;
        this.product = product;
        this.order_date = order_date;
        this.transaction = transaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getOrderDate() {
        return order_date;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double calTotalAmount() {
        int sum = 0;
        for (Product product : products) {
            double price = product.getPrice();
            int quantity = product.getQuantity();
            sum += price * quantity;
        }
        return sum;
    }
}
