package ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Customer;
import model.Employee;
import model.Transaction;
import model.TransactionID;
import model.Strategy.payment.PaymentStrategy;
import repository.EmployeeRepository;
import services.EmployeeManager;
import services.TransactionManager;
import validation.InpuValidator;

public class TransactionUI extends OrderUI {
    static String file_path = "convenient_store_management/src/data/employee_data.txt";

    public static Employee chooseEmployee(Scanner scanner) {
        List<Employee> employeeDataFromFile = EmployeeRepository.readFileEmployee(file_path);
        EmployeeManager.exportAllEmployee(employeeDataFromFile);

        System.out.print("Nhap id nhan vien thu ngan: ");
        int idEmployee = InpuValidator.validateIntInput(scanner);
        scanner.nextLine();

        for (Employee employee : employeeDataFromFile) {
            if (employee.getId() == idEmployee) {
                return employee;
            }
        }

        System.out.println("Khong ton tai ma nhan vien");
        return null;
    }

    public static void handleTransaction(Scanner scanner, List<Transaction> transactions) {
        TransactionManager manager = new TransactionManager();

        while (true) {
            Menu.menuTransaction();
            BaseEntity.resetId();
            System.out.print("Nhap tuy chon: ");
            int option = InpuValidator.validateIntInput(scanner);
            scanner.nextLine();

            if (option == 1) {

                Employee employee = chooseEmployee(scanner);

                System.out.print("Nhap ten khach hang: ");
                String name_customer = InpuValidator.validateStringInput(scanner);

                System.out.print("Nhap tong so tien: ");
                double total_amount = InpuValidator.validateDoubleInput(scanner);
                scanner.nextLine();

                LocalDate transaction_date = LocalDate.now();

                PaymentStrategy payment_method = choosePaymentMethod(scanner);

                Customer customer = new Customer(name_customer);

                Transaction new_transaction = new Transaction(total_amount, transaction_date, payment_method, customer,
                        employee);
                manager.create(new_transaction);

                System.out.println("Da tao giao dich thanh cong!");

                System.out.print("An Enter de tiep tuc...!");
                scanner.nextLine();

            } else if (option == 2) {

                if (transactions.isEmpty()) {
                    System.out.println("Khong co giao dich nao!");
                } else {
                    TransactionManager.exportAllTransaction(transactions);
                }
                System.out.print("An Enter de tiep tuc...!");
                scanner.nextLine();

            } else if (option == 3) {

                System.out.print("Nhap ma giao dich: ");
                int transaction_id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();

                Transaction result_search = manager.search(transaction_id);

                if (result_search != null) {
                    TransactionManager.exportTransaction(result_search);

                } else {
                    System.out.print("Khong tim thay giao dich co ma " + transaction_id);
                }

                System.out.print("An Enter de tiep tuc...!");
                scanner.nextLine();
            } else if (option == 0) {
                TransactionID.resetId();
                BaseEntity.resetId();
                TransactionManager.saveFile();
                // continue;
                break;
            } else {
                System.out.println("Tuy chon khong hop le. Vui long nhap lai");
                continue;

            }

        }
    }

}