import java.util.Scanner;
import ui.*;
import services.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
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

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    // xử lý logic cho quản lý nhân viên
                    EmployeeManager.startEmployeeManager(scanner);
                    break;
                case 6:
                    // xử lý logic cho quản lý kho
                    break;
                case 7:

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