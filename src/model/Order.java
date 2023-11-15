package model;

import java.time.LocalDate;
import java.util.List;

import model.Strategy.InvoiceCalculationStrategy;

public class Order extends BaseOrderId {
    private Product product;
    private List<Product> products;
    private Customer customer;
    private Employee employee;
    private Transaction transaction;
    private LocalDate order_date;
    private InvoiceCalculationStrategy calculateStrategy;

    public Order(List<Product> products, LocalDate order_date, Customer customer, Employee employee,
            Transaction transaction, InvoiceCalculationStrategy calculationStrategy) {
        this.customer = customer;
        this.employee = employee;
        this.products = products;
        this.transaction = transaction;
        this.order_date = order_date;
        this.calculateStrategy = calculationStrategy;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTransaction(Transaction transaction) {
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

    public double calculateTotal() {
        double sum = 0;
        for (Product product : products) {
            double price = product.getPrice();
            int quantity = product.getQuantity();
            sum += price * quantity;
        }
        return calculateStrategy.calculateTotal(sum);
    }

}
