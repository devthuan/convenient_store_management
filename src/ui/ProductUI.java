package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Product;
import services.ProductManager;

public class ProductUI {
    public static void handleProduct(Scanner scanner, List<Product> products) {
        ProductManager manager = new ProductManager();

        while (true) {
            Menu.menuProduct();
            System.out.print("Nhập tuỳ chọn: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập số nguyên!");
                scanner.next();
            }
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {

                System.out.print("Nhân tên sản phẩm: ");
                String name = scanner.nextLine();

                System.out.print("Nhập giá: ");
                double price = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nhập mô tả sản phẩm: ");
                String description = scanner.nextLine();

                Product new_product = new Product(name, price, description);
                manager.create(new_product);

                System.out.println("Tạo sản phẩm mới thành công.");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 2) {

                if (products == null) {
                    System.out.println("Không có nhân viên nào.");
                } else {
                    ProductManager.exportAllProducts(products);

                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 3) {

                System.out.print("Nhập mã sản phẩm: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Product product_finded = manager.search(id);
                if (product_finded != null) {
                    ProductManager.exportProduct(product_finded);
                } else {
                    System.out.println("Không tìm sản phẩm có mã " + id);

                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhập mã sản phẩm: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                manager.delete(id);

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.print("Nhập mã sản phẩm cần update: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Product product_finded = manager.search(id);

                if (product_finded != null) {
                    System.out.print("Nhân tên sản phẩm: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập giá: ");
                    double price = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập mô tả sản phẩm: ");
                    String description = scanner.nextLine();

                    Product update_product = new Product(name, price, description);

                    manager.update(id, update_product);

                    System.out.print("Cập nhật sản phẩm thành công.");

                } else {
                    System.out.print("Không tìm thấy mã sản phẩm cần sửa!!!");

                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 0) {
                BaseEntity.resetId();

                ProductManager.saveFile();
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }
        }
    }
}
