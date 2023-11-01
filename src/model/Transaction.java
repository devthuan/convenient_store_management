package model;

import java.util.List;

public class Transaction extends BaseEntity {

    private int transaction_id;
    private double total_amount;
    private String transaction_date;
    private String payment_method;
    private Customer customer;
    private Employee employee;

    public Transaction() {

    }

    public Transaction(String payment_method) {
        this.payment_method = payment_method;
    }
    public Transaction(double total_amount, String payment_method){
        this.total_amount = total_amount;
        this.payment_method = payment_method;
    }

    public Transaction(int transaction_id, double total_amount, String transaction_date, String payment_method,
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

    public String getTransactionDate() {
        return transaction_date;
    }

    public String getPaymentMethod() {
        return payment_method;
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

    public void setTransactionDate(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public void setPaymentMethod(String payment_method) {
        this.payment_method = payment_method;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static void exportTransaction(Transaction transaction) {
        System.out.println("------------------------------------------------");
        System.out.println("ID                    : " + transaction.getTransactionId());
        System.out.println("Thu ngân              : " + transaction.getEmployee());
        System.out.println("Khách hàng            : " + transaction.getCustomer());
        System.out.println("Tổng tiền             : " + transaction.getTotalAmount());
        System.out.println("Ngày giao dịch        : " + transaction.getTransactionDate());
        System.out.println("Phương thức thanh toán: " + transaction.getPaymentMethod());
        System.out.println("------------------------------------------------");
    }

    public static void exportAllTransaction(List<Transaction> transactions) {
        if (transactions != null) {
            System.out.println("===================================");
            System.out.println("         LỊCH SỬ GIAO DỊCH         ");
            System.out.println("===================================");
            System.out.println(
                    "-------+------------------+--------------------+-------------------+--------------------------+-------------------------------------");
            System.out.println(
                    "|  ID  |     THU NGÂN     |     KHÁCH HÀNG     |     TỔNG TIỀN     |      NGÀY GIAO DỊCH      |       PHƯƠNG THỨC THANH TOÁN       |");
            System.out.println(
                    "-------+------------------+--------------------+-------------------+--------------------------+-------------------------------------");
            for (Transaction transaction : transactions) {

                System.out.println(
                        String.format("| %4s | %19s | %11s | %6s | %15s | %10s |",
                                transaction.getTransactionId(),
                                transaction.getEmployee(),
                                transaction.getCustomer(),
                                transaction.getTotalAmount(),
                                transaction.getTransactionDate(),
                                transaction.getPaymentMethod()));
            }
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();

        } else {
            System.out.println("Không có dữ liệu nào!");
        }
    }

}