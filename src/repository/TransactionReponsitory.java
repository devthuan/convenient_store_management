package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import model.Employee;
import model.NVBH;
import model.Customer;
import model.Transaction;
import model.Strategy.payment.CardPayment;
import model.Strategy.payment.CashPayment;
import model.Strategy.payment.MomoPayment;
import model.Strategy.payment.PaymentStrategy;

import java.util.List;
import java.util.ArrayList;

public class TransactionReponsitory {
    public static void writeFileTransaction(Transaction transaction, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            writer.write(transaction.getTransactionId() + "," +
                    transaction.getEmployee() + "," +
                    transaction.getCustomer() + "," +
                    transaction.getTotalAmount() + "," +
                    transaction.getTransactionDate() + "," +
                    transaction.getPaymentMethod());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ
        }
    }

    public static void writeTransactionToFile(List<Transaction> transactions, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.getId() + "," +
                        transaction.getEmployee().getName() + "," +
                        transaction.getCustomer().getName() + "," +
                        transaction.getTotalAmount() + "," +
                        transaction.getTransactionDate() + "," +
                        transaction.getPaymentMethod());
                writer.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ
        }
    }

    public static List<Transaction> readFileTransaction(String file_path) {
        List<Transaction> transactionList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    int transaction_id = Integer.parseInt(data[0]);
                    Customer customer = new Customer(data[1]);
                    Employee employee = new NVBH(data[2]);
                    double total_amount = Double.parseDouble(data[3]);
                    LocalDate transaction_date = LocalDate.parse(data[4]);
                    String payment_method_string = data[5];

                    PaymentStrategy payment_method;

                    if (payment_method_string.equals("Chuyen khoan momo")) {
                        payment_method = new MomoPayment();
                    } else if (payment_method_string.equals("The tin dung")) {
                        payment_method = new CardPayment();

                    } else {
                        payment_method = new CashPayment();

                    }

                    Transaction transaction = new Transaction(transaction_id, total_amount, transaction_date,
                            payment_method, customer,
                            employee);
                    transactionList.add(transaction);
                } else {
                    // Xử lý lỗi định dạng dữ liệu
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Xử lý lỗi đọc tệp
        }

        return transactionList;
    }

}
