
import java.util.Scanner;
import functional.InvoiceManagement;
import object.Invoice;

import ui.*;
import services.*;

public class App {

    // hàm xử lý logic cho quản lý hoá đơn

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        InvoiceManagement managerEmployee = new InvoiceManagement();
        Invoice invoice = new Invoice();

        while (true) {
            Menu.menuMain();
            System.out.println("Nhập tuỳ chọn: ");
            int main_choice = scanner.nextInt();

            switch (main_choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    // xử lý logic cho quản lý hoá đơn
                    // manager.handleVoices(invoice, scanner);
                    break;
                case 4:
                    break;
                case 5:
                    // xử lý logic cho quản lý nhân viên
                    EmployeeManager.startEmployeeManager(scanner);
                    break;
                case 0:
                    System.out.println("Bye.");
                    System.exit(0);
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                    break;

            }

        }
    }

}
