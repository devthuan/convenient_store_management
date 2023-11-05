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
                    CustomerManager.readFile();
                    CustomerManager.startCustomerManager(scanner);
                    break;
                case 2:
                    //
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    EmployeeManager.readFile();
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