package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.InterfaceCRUD;
import model.Product;
import repository.CustomerRepository;
import ui.CustomerUI;

public class CustomerManager implements InterfaceCRUD {
    static List<Customer> customers = new ArrayList<>();
    static String file_path = "src/data/customer_data.txt";

    public static void startCustomerManager(Scanner scanner) {
        CustomerUI.handleCustomer(scanner, customers);
    }

    public static void saveFile() {
        CustomerRepository.writeCustomerToFile(customers, file_path);
        customers.clear();

    }

    public static void readFile() {
        List<Customer> customers_in_file = CustomerRepository.readFileCustomer(file_path);

        // Xóa danh sách sản phẩm hiện tại trước khi thêm sản phẩm từ tệp
        customers.clear();
        if (customers_in_file != null) {
            for (Customer customer : customers_in_file) {
                customers.add(customer);
            }

        }
    }

    @Override
    public void create(Object entity) {

    }

    @Override
    public Object read(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(int id) {
        Customer customerToRemove = (Customer) read(id);
        if (customerToRemove != null) {
            customers.remove(customerToRemove);
            System.out.println("Đã xóa khách hàng có mã " + id);
        } else {
            System.out.println("Không tìm thấy khách hàng có mã " + id);
        }
    }

    @Override
    public Customer search(int id) {
        return (Customer) read(id);
    }

}