package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerRepository {
    public static List<Customer> readFileCustomer(String file_path) {
        List<Customer> CustomerList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String address = data[2];
                    String phone = data[3];

                    Customer customer = new Customer(id, name, address, phone);
                    CustomerList.add(customer);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return CustomerList;
    }

    public static void writeFileCustomer(Customer customer, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            writer.write(customer.getId() + "," +
                    customer.getName() + "," +
                    customer.getAddress() + "," +
                    customer.getPhone());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void writeCustomerToFile(List<Customer> customers, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Customer customer : customers) {
                writer.write(customer.getId() + "," +
                        customer.getName() + "," +
                        customer.getAddress() + "," +
                        customer.getPhone());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}