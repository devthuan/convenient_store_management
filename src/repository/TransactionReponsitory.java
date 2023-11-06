package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Employee;
import model.Customer;
import model.Transaction;
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

    public static void writeTransactionToFile(List<Transaction> transaction, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Transaction transaction : transaction) {
                writer.write(transaction.getTransactionId() + "," +
                    transaction.getEmployee() + "," +
                    transaction.getCustomer() + "," +
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
                    double total_amount = Double.parseDouble(data[1]);
                    String transaction_date = data[2];
                    String payment_method = data[3];
                    Customer customer = Customer.parseCustomer[4];
                    Employee employee = Employee.parseEmployee[5];

                    Transaction transaction = new Transaction(transaction_id, total_amount, transaction_date, payment_method, customer, employee);
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
