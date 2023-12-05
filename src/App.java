import java.util.Scanner;
import ui.*;
import validation.InpuValidator;
import services.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.menuMain();
            System.out.println("Nhap tuy chon: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui long nhap so nguyen!");
                scanner.next();
            }
            int main_choice = InpuValidator.validateIntInput(scanner);
            switch (main_choice) {
                case 1:
                    ProductManager.readFile(); // load data từ file txt
                    ProductManager.startProductManager(scanner);
                    break;
                case 2:
                    CustomerManager.readFile();
                    CustomerManager.startCustomerManager(scanner);
                    break;
                case 3:

                    ProductManager.readFile();
                    OrderManager.readFile();
                    OrderManager.startOrderManager(scanner);
                    break;
                case 4:

                    EmployeeManager.readFile();
                    EmployeeManager.startEmployeeManager(scanner);

                    break;
                case 5:
                    InventoryManager.readFile();
                    InventoryManager.startInventoryManager(scanner);
                    break;
                case 6:
                    TransactionManager.readFile();
                    TransactionManager.startTransactionManager(scanner);
                    break;
                case 0:
                    System.out.println("Bye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Tuy chon khong hop le. Vui long nhap lai");
                    break;

            }

        }
    }

}