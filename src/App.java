import java.util.Scanner;
import ui.*;
import services.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.menuMain();
            System.out.println("Nhập tuỳ chọn: ");
            int main_choice = scanner.nextInt();

            switch (main_choice) {
                case 1:
                    // xử lý logic cho quản lý khách hàng
                    CustomerManager.readFile();
                    CustomerManager.startCustomerManager(scanner);
                    break;
                case 2:
                    // xử lý logic cho quản lý sản phẩm
                    ProductManager.readFile(); // load data từ file txt
                    ProductManager.startProductManager(scanner);
                    break;
                case 3:
                    // xử lý logic cho quản lý hoá đơn
                    OrderManager.readFile(); // load data từ file txt
                    OrderManager.startOrderManager(scanner);

                    break;
                case 4:

                    break;
                case 5:
                    // xử lý logic cho quản lý nhân viên
                    EmployeeManager.readFile();
                    EmployeeManager.startEmployeeManager(scanner);
                    break;
                case 6:
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