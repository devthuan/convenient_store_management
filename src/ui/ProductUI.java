package ui;

import java.util.List;
import java.util.Scanner;

import model.Product;
import services.ProductManager;

public class ProductUI {
    public static void handleProduct(Scanner scanner, List<Product> products) {
        ProductManager manager = new ProductManager();
        while (true) {
            Menu.menuProduct();
            System.out.print("Nhập tuỳ chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {

            } else if (option == 2) {

            } else if (option == 3) {

            } else if (option == 4) {

            } else if (option == 0) {
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }
        }
    }
}
