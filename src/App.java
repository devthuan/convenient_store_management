import java.util.Scanner;
import ui.*;
import services.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.menuMain();
            System.out.println("Nhập tuỳ chọn: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập số nguyên!");
                scanner.next();
            }
            int main_choice = scanner.nextInt();
            switch (main_choice) {
                case 1:
                    // xử lý logic cho quản lý cửa hàng

                    break;
                case 2:
                    // xử lý logic cho quản lý sản phẩm
                    ProductManager.readFile(); // load data từ file txt
                    ProductManager.startProductManager(scanner);
                    break;
                case 3:
                    // xử lý logic cho quản lý khách hàng
                    CustomerManager.readFile();
                    CustomerManager.startCustomerManager(scanner);
                    break;
                case 4:
                    // xử lý logic cho quản lý hoá đơn
                    ProductManager.readFile(); // load data product từ file txt
                    OrderManager.readFile(); // load data order từ file txt
                    OrderManager.startOrderManager(scanner);
                    break;
                case 5:
                    // xử lý logic cho quản lý nhân viên
                    EmployeeManager.readFile();
                    EmployeeManager.startEmployeeManager(scanner);
                    break;
                case 6:
                    // xử lý logic cho quản lý kho
                    break;
                case 7:
                    // xử lí logic cho lịch sử giao dịch
                    TransactionManager.readFile();
                    TransactionManager.startTransactionManager(scanner);
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