package repository;

import java.io.BufferedWriter;
import java.io.FileWriter;

import model.Employee;
import model.Transaction;

public class TransactionReponsitory {
     public static void writeFile(Transaction transaction, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            writer.write(transaction.getTransactionId() + "," +
                    transaction.getEmployee() + "," +
                    transaction.getCustomer() + "," +
                    transaction.getTotalAmount() + "," +
                    transaction.getTransactionDate() + "," +
                    transaction.getPaymentMethod());
            writer.newLine();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
