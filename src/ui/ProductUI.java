package ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Product;
import model.Categories.Drinks;
import model.Categories.Food;
import services.ProductManager;
import validation.InpuValidator;

public class ProductUI {

    public static Product chooseCategory(Scanner scanner) {
        System.out.println("1. Do uong");
        System.out.println("2. Thuc an");

        System.out.print("Chon loai san pham: ");
        int choice_product = InpuValidator.validateIntInput(scanner);
        scanner.nextLine();

        System.out.print("Nhap ten san pham: ");
        String name = InpuValidator.validateStringInput(scanner);

        System.out.print("Nhap gia: ");
        double price = InpuValidator.validateDoubleInput(scanner);
        scanner.nextLine();

        System.out.print("Nhap so luong: ");
        int quantity = InpuValidator.validateIntInput(scanner);
        scanner.nextLine();

        System.out.print("Nhap han su dung (yyyy-mm-dd): ");
        LocalDate expire = InpuValidator.validateLocalDateInput(scanner);

        switch (choice_product) {
            case 1:
                System.out.print("Do uong co con hay khong: y/n ");
                String choice_type_drink = InpuValidator.validateStringInput(scanner);
                Boolean contains_alcohol = false;
                if (choice_type_drink.equalsIgnoreCase("y")) {
                    contains_alcohol = true;
                }
                return new Drinks(name, price, quantity, expire, contains_alcohol, "Do uong");
            case 2:

                return new Food(name, price, quantity, expire, "Thuc an");

        }
        return null;
    }

    public static Product updateProduct(Scanner scanner, Product product) {

        System.out.print("Nhap gia: ");
        double price = InpuValidator.validateDoubleInput(scanner);
        scanner.nextLine();

        System.out.print("Nhap han su dung san pham (yyyy-mm-dd): ");
        LocalDate expire = InpuValidator.validateLocalDateInput(scanner);

        if (product != null && product != null) {

            if (product instanceof Drinks) {
                Drinks drink = (Drinks) product;
                return new Drinks(drink.getName(), price, 1, expire, drink.getContainsAlcohol(),
                        drink.getCategory());
            } else if (product instanceof Food) {
                Food food = (Food) product;
                return new Food(food.getName(), price, 1, expire, food.getCategory());
            } else {
                System.out.println("Loai san pham khong duoc ho tro.");
            }
        } else {
            System.out.println("Don hang khong hop le, hoac khong co san pham.");
        }

        return null;
    }

    public static void handleProduct(Scanner scanner, List<Product> products) {
        ProductManager manager = new ProductManager();

        while (true) {
            Menu.menuProduct();
            System.out.print("Nhap tuy chon: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui long nhap so nguyen!");
                scanner.next();
            }
            int option = InpuValidator.validateIntInput(scanner);
            scanner.nextLine();
            if (option == 1) {

                Product new_product = chooseCategory(scanner);
                manager.create(new_product);

                System.out.println("Tao san pham moi thanh cong.");

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 2) {

                if (products.isEmpty()) {
                    System.out.println("Không có sản phẩm nào.");
                } else {
                    ProductManager.exportAllProducts(products);

                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 3) {

                System.out.print("Nhap ma san pham: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();

                Product product_finded = manager.search(id);
                if (product_finded != null) {
                    ProductManager.exportProduct(product_finded);
                } else {
                    System.out.println("Khong tim thay san pham co ma " + id);

                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhap ma san pham: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                manager.delete(id);

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.print("Nhap ma san pham can chinh sua: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Product product_finded = manager.search(id);

                if (product_finded != null) {

                    Product update_product = updateProduct(scanner, product_finded);

                    manager.update(id, update_product);

                    System.out.print("Cap nhat san pham thanh cong.");

                } else {
                    System.out.print("Khong tim thay san pham can sua!!!");

                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 0) {
                BaseEntity.resetId();

                ProductManager.saveFile();
                break;
            } else {
                System.out.println("Tuy chon khong hop le. Vui long nhap lai");
                continue;

            }
        }
    }
}
