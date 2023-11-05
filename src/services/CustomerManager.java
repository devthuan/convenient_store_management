package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.InterfaceCRUD;
import model.Order;
import model.Product;
import repository.CustomerRepository;
import repository.OrderRespository;
import ui.CustomerUI;

public class CustomerManager implements InterfaceCRUD<Customer> {
    static List<Customer> customers = new ArrayList<>();
    static String file_path = "src/data/customer_data.txt";

    public static void startCustomerManager(Scanner scanner) {
        CustomerUI.handleCustomer(scanner, customers);
    }

    public static void readFile() {
        List<Customer> data_customers = CustomerRepository.readFileCustomer(file_path);

        customers.clear();
        for (Customer customer : data_customers) {
            customers.add(customer);
        }
    }

    public static void saveFile() {
        CustomerRepository.writeCustomersToFile(customers, file_path);
    }

    @Override
    public void create(Customer customer) {
        // customers.add(customer);
    }

    @Override
    public Customer read(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Customer updateCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getId() == id) {
                customer.setName(updateCustomer.getName());
                customer.setAddress(updateCustomer.getAddress());
                customer.setPhone(updateCustomer.getPhone());
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        Customer deleteCustomer = null;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                deleteCustomer = customer;
                break;
            }
        }

        if (deleteCustomer != null) {
            customers.remove(deleteCustomer);
            System.out.println("Da xoa khach hang co ma " + id);
        } else {
            System.out.println("Khong tim thay khach hang co ma " + id);
        }
    }

    @Override
    public Customer search(int id) {
        return (Customer) read(id);
    }

}
