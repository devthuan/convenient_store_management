package ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Customer;
import model.Employee;
import model.Order;
import model.Transaction;
import model.Strategy.payment.PaymentStrategy;
import repository.OrderRespository;
import services.TransactionManager;
import validation.InpuValidator;

public class TransactionUI extends OrderUI {
    public static String file_path = "convenient_store_management/src/data/order_data.txt";

    public static void handleTransaction(Scanner scanner, List<Transaction> transactions) {
        TransactionManager manager = new TransactionManager();

        while (true) {
            Menu.menuTransaction();

            System.out.print("Nhap tuy chon: ");
            int option = InpuValidator.validateIntInput(scanner);
            scanner.nextLine();

            if (option == 1) {

                System.out.print("Nhap ten thu ngan: ");
                String name_employee = scanner.nextLine();

                System.out.print("Nhap ten khach hang: ");
                String name_customer = scanner.nextLine();

                System.out.print("Nhap tong so tien: ");
                double total_amount = InpuValidator.validateDoubleInput(scanner);
                scanner.nextLine();

                LocalDate transaction_date = LocalDate.now();

                PaymentStrategy payment_method = choosePaymentMethod(scanner);

                Employee employee = new Employee(name_employee);
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