package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Product;
import model.Categories.Drinks;
import model.Categories.Food;
import services.ProductManager;

public class ProductUI {

    public static Product chooseCategory(Scanner scanner) {
        System.out.println("1. Đồ uống");
        System.out.println("2. Thức ăn");

        System.out.print("Chọn Loại sản phẩm: ");
        int choice_product = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhân tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá: ");
        double price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập hạn sử dụng sản phẩm: ");
        String expire = scanner.nextLine();

        switch (choice_product) {
            case 1:
                System.out.print("đồ uống có cồn hay không: y/n ");
                String choice_type_drink = scanner.nextLine();
                Boolean contains_alcohol = false;
                if (choice_type_drink.equalsIgnoreCase("y")) {
                    contains_alcohol = true;
                }
                return new Drinks(name, price, 1, expire, contains_alcohol, "Đồ uống");
            case 2:

                return new Food(name, price, 1, expire, "Thức ăn");

        }
        return null;
    }

    public static Product updateProduct(Scanner scanner, Product product) {

        System.out.print("Nhập giá: ");
        double price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập hạn sử dụng sản phẩm (dd-mm-yyyy): ");
        String expire = scanner.nextLine();

        if (product != null && product != null) {

            if (product instanceof Drinks) {
                Drinks drink = (Drinks) product;
                return new Drinks(drink.getName(), price, 1, expire, drink.getContainsAlcohol(),
                        drink.getCategory());
            } else if (product instanceof Food) {
                Food food = (Food) product;
                return new Food(food.getName(), price, 1, expire, food.getCategory());
            } else {
                System.out.println("Loại sản phẩm không được hỗ trợ.");
            }
        } else {
            System.out.println("Đơn hàng không hợp lệ hoặc không có sản phẩm.");
        }

        return null;
    }

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

                Product new_product = chooseCategory(scanner);
                manager.create(new_product);

                System.out.println("Tạo sản phẩm mới thành công.");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 2) {

                if (products.isEmpty()) {
                    System.out.println("Không có sản phẩm nào.");
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

                    Product update_product = updateProduct(scanner, product_finded);

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
