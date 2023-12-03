package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.InterfaceCRUD;
import repository.CustomerRepository;
import ui.CustomerUI;

public class CustomerManager implements InterfaceCRUD<Customer> {
    static List<Customer> customers = new ArrayList<>();
    static String file_path = "convenient_store_management/src/data/customer_data.txt";

    public static void startCustomerManager(Scanner scanner) {
        CustomerUI.handleCustomer(scanner, customers);
    }

    public static void exportCustomer(Customer customer) {
        System.out.println("------------------------------------------------");
        System.out.println("Ma khach hang            : " + customer.getId());
        System.out.println("Ho va ten khach hang     : " + customer.getName());
        System.out.println("Dia chi khach hang       : " + customer.getAddress());
        System.out.println("So dien thoai khach hang :" + customer.getPhone());
        System.out.println("------------------------------------------------");
    }

    public static void exportAllEmployee(List<Customer> customers) {
        if (customers != null) {
            System.out.println("===================================");
            System.out.println("         DANH SÁCH KHÁCH HÀNG       ");
            System.out.println("===================================");
            System.out.println("-------+--------------------- +----------------------------+-------------------");
            System.out.println("|  ID  |       Ho va ten      |           Dia chi          |   So dien thoai  |");
            System.out.println("-------+----------------------+----------------------------+-------------------");
            for (Customer customerInformation : customers) {
                System.out.println(
                        String.format("| %4s | %19s | %27s | %16s |",
                                customerInformation.getId(),
                                customerInformation.getName(),
                                customerInformation.getAddress(),
                                customerInformation.getPhone()));
            }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Khong co thong tin nao ve khach hang");
        }
    }

    public static void saveFile() {
        CustomerRepository.writeCustomerToFile(customers, file_path);
        customers.clear();

    }

    public static void readFile() {
        List<Customer> customers_in_file = CustomerRepository.readFileCustomer(file_path);
        customers.clear();
        if (customers_in_file != null) {
            for (Customer customer : customers_in_file) {
                customers.add(customer);
            }

        }
    }

    @Override
    public void create(Customer customer) {
        customers.add(customer);

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
    public void update(int id, Customer updated_customer) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                foundCustomer = customer;
                break;
            }
        }
        if (foundCustomer != null) {
            foundCustomer.setName(updated_customer.getName());
            foundCustomer.setAddress(updated_customer.getAddress());
            foundCustomer.setPhone(updated_customer.getPhone());
            System.out.println("Cap nhat thong tin khach hang thanh cong");
        }
    }

    @Override
    public void delete(int id) {
        Customer customerToRemove = (Customer) read(id);
        if (customerToRemove != null) {
            customers.remove(customerToRemove);
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