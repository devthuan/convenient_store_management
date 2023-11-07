package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Customer;
import model.Employee;
import model.Transaction;
import services.TransactionManager;

public class TransactionUI {
    public static void handleTransaction(Scanner scanner, List<Transaction> transaction) {
        TransactionManager manager = new TransactionManager();

        while (true) {
            Menu.menuTransaction();
            System.out.print("Nhập tuỳ chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Chức năng đang được phát triển");

            } else if (option == 2) {

                System.out.print("Chức năng đang được phát triển");

            } else if (option == 3) {

                System.out.print("Chức năng đang được phát triển");
                System.out.print("Ấn Enter để tiếp tục!");
                scanner.nextLine();

            } else if (option == 4) {

                System.out.print("Chức năng đang được phát triển");

            } else if (option == 5) {

                System.out.print("Chức năng đang được phát triển");

            } else if (option == 0) {

                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại!");
                continue;

            }

        }
    }

}
