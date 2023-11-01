package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.InterfaceCRUD;
import repository.CustomerRepository;
import ui.CustomerUI;

public class CustomerManager implements InterfaceCRUD<Customer> {
    static List<Customer> customers = new ArrayList<>();

    public static void startCustomerManager(Scanner scanner) {
        CustomerUI.handleCustomer(scanner, customers);
    }

    @Override
    public void create(Customer entity) {
        if (entity instanceof Customer) {
            Customer customer = (Customer) entity;
            customers.add(customer);

            String file_path = "convenient_store_management/src/data/customer_data.txt";

            CustomerRepository.writeFile(customer, file_path);
        }
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
    public void update(int id, Customer entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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
