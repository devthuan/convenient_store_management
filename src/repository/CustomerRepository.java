package repository;

import java.io.BufferedWriter;
import java.io.FileWriter;

import model.Customer;

public class CustomerRepository {

    public static void writeFile(Customer customer, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            writer.write(customer.getId() + "," +
                    customer.getName() + "," +
                    customer.getAddress() + "," +
                    customer.getPhone());
            writer.newLine();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
