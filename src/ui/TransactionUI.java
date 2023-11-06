package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Customer;
import model.Employee;
import model.Transaction;
import repository.TransactionRepository;
import services.TransactionManager;

public class TransactionUI {
    public static void handleTransaction(Scanner scanner, List<Transaction> transaction) {
        TransactionManager manager = new TransactionManager();
        String file_path = "convenient_store_management/src/data/transaction_data.txt";

        while (true) {
            Menu.menuTransaction();
            System.out.print("Nhập tuỳ chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Nhập mã giao dịch: ");
                int transaction_id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nhập tên thu ngân: ");
                String name_employee = scanner.nextLine();
                Employee employee = new Employee(name_employee);

                System.out.print("Nhập tên khách hàng: ");
                String name_customer = scanner.nextLine();
                Customer customer = new Customer(name_customer);

                System.out.print("Nhập tổng số tiền: ");
                double total_amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Nhập ngày giao dịch: ");
                String transaction_date = scanner.nextLine();

                System.out.print("Nhập phương thức thanh toán: ");
                String payment_method = scanner.nextLine();

                Transaction new_transaction = new Transaction(transaction_id, employee, customer, total_amount, transaction_date, payment_method);
                transaction.add(new_transaction);

                ProductRespository.writeFileTransaction(new_transaction, file_path);
                System.out.println("Đã tạo giao dịch thành công!");

                System.out.print("Ấn Enter để tiếp tục!");
                scanner.nextLine();

            } else if (option == 2) {

                if (transaction.isEmpty()) {
                    System.out.println("Không có giao dịch nào!");
                } else {
                    Transaction.exportAllTransaction(transaction);

                }
                System.out.print("Ấn Enter để tiếp tục!");
                scanner.nextLine();

            } else if (option == 3) {

                System.out.print("Nhập mã giao dịch: ");
                int transaction_id = scanner.nextInt();
                scanner.nextLine();

                Transaction result_search = manager.search(transaction_id);

                if (result_search != null) {
                    Transaction.exportTransaction(result_search);

                } else {
                    System.out.print("Không tìm thấy giao dịch có mã " + transaction_id);
                }
                System.out.print("Ấn Enter để tiếp tục!");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhập mã giao dịch: ");
                int transaction_id = scanner.nextInt();
                scanner.nextLine();
                manager.delete(transaction_id);

            } else if (option == 5) {
                System.out.print("Nhập mã giao dịch cần update: ");
                int transaction_id = scanner.nextInt();
                scanner.nextLine();

                Transaction transaction_finded = manager.search(transaction_id);

                if (transaction_finded != null) {
                    System.out.print("Nhập mã giao dịch: ");
                    int transaction_id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập tên thu ngân: ");
                    String name_employee = scanner.nextLine();
                    Employee employee = new Employee(name_employee);

                    System.out.print("Nhập tên khách hàng: ");
                    String name_customer = scanner.nextLine();
                    Customer customer = new Customer(name_customer);

                    System.out.print("Nhập tổng số tiền: ");
                    double total_amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Nhập ngày giao dịch: ");
                    String transaction_date = scanner.nextLine();

                    System.out.print("Nhập phương thức thanh toán: ");
                    String payment_method = scanner.nextLine();


                    Transaction update_transaction = new Transaction(transaction_id, employee, customer, total_amount, transaction_date, payment_method);

                    manager.update(transaction_id, update_transaction);

                    System.out.print("Cập nhật giao dịch thành công!");

                } else {
                    System.out.print("Không tìm thấy mã giao dịch cần sửa!");

                }

                System.out.print("Ấn Enter để tiếp tục!");
                scanner.nextLine();
            } else if (option == 0) {
                BaseEntity.resetId();
                TransactionManager.saveFile();
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại!");
                continue;

            }

        }
    }

}
