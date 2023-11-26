package model;

import java.time.LocalDate;

import model.Strategy.payment.PaymentStrategy;

public class Transaction extends TransactionID {

    private int transaction_id;
    private double total_amount;
    private LocalDate transaction_date;
    private Customer customer;
    private Employee employee;
    private PaymentStrategy payment_method;

    public Transaction() {

    }

    public Transaction(PaymentStrategy payment_method) {
        this.payment_method = payment_method;
    }

    public Transaction(double total_amount, PaymentStrategy payment_method) {
        this.total_amount = total_amount;
        this.payment_method = payment_method;
    }

    public Transaction(double total_amount, LocalDate transaction_date, PaymentStrategy payment_method,
            Customer customer, Employee employee) {

        this.total_amount = total_amount;
        this.transaction_date = transaction_date;
        this.payment_method = payment_method;
        this.customer = customer;
        this.employee = employee;
    }

    public Transaction(int transaction_id, double total_amount, LocalDate transaction_date,
            PaymentStrategy payment_method,
            Customer customer, Employee employee) {
        this.transaction_id = transaction_id;
        this.total_amount = total_amount;
        this.transaction_date = transaction_date;
        this.payment_method = payment_method;
        this.customer = customer;
        this.employee = employee;
    }

    public int getTransactionId() {
        return transaction_id;
    }

    public double getTotalAmount() {
        return total_amount;
    }

    public String getPaymentMethod() {
        if (payment_method != null) {
            return payment_method.getPaymentMethod();
        } else {
            return null; // hoặc trả về một giá trị mặc định tùy thuộc vào yêu cầu của bạn
        }
    }

    public LocalDate getTransactionDate() {
        return transaction_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setTransactionId(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public void setTotalAmount(double total_amount) {
        this.total_amount = total_amount;
    }

    public void setTransactionDate(LocalDate transaction_date) {
        this.transaction_date = transaction_date;
    }

    public void setPaymentMethod(PaymentStrategy payment_method) {
        this.payment_method = payment_method;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}