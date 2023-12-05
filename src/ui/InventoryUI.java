package ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.Inventory;
import model.Product;
import model.Categories.Food;

import services.InventoryManager;
import validation.InpuValidator;

public class InventoryUI extends ProductUI {

    public static void handleInventory(Scanner scanner, List<Inventory> inventories) {
        InventoryManager manager = new InventoryManager();

        while (true) {
            Menu.menuInventory();
            System.out.print("Nhap tuy chon: ");
            int option = InpuValidator.validateIntInput(scanner);
            scanner.nextLine();

            if (option == 1) {

                Product product = chooseCategory(scanner);
                LocalDate now_date = LocalDate.now();
                Inventory new_item = new Inventory(product, now_date, null);
                manager.create(new_item);

                System.out.println("Da nhap san pham vao kho thanh cong.");

                System.out.print("An Enter de tiep....");
                scanner.nextLine();

            } else if (option == 2) {
                if (inventories.isEmpty()) {
                    System.out.println("Kho hang trong.");
                } else {
                    InventoryManager.exportInventories(inventories);

                }

                System.out.print("An Enter de tiep....");
                scanner.nextLine();
            } else if (option == 3) {
                System.out.print("Nhap ma san pham: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();

                Inventory inventory_finded = manager.search(id);

                if (inventory_finded != null) {
                    InventoryManager.exportInventory(inventory_finded);
                } else {
                    System.out.println("Trong kho hang khong co san pham co ma " + id);
                }

                System.out.print("An Enter de tiep....");
                scanner.nextLine();

            } else if (option == 4) {
                System.out.print("Nhap ma san pham can chinh sua: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();

                Inventory inventory_finded = manager.search(id);

                if (inventory_finded != null) {
                    System.out.print("Nhap so luong san pham: ");
                    int new_quantity = InpuValidator.validateIntInput(scanner);
                    scanner.nextLine();

                    System.out.print("Nhap han su dung (yyyy-mm-dd): ");
                    LocalDate new_expire = InpuValidator.validateLocalDateInput(scanner);

                    Product product_updated = new Food(inventory_finded.getProduct().getName(),
                            inventory_finded.getProduct().getPrice(), new_quantity,
                            new_expire, inventory_finded.getProduct().getCategory());
                    inventory_finded.setProduct(product_updated);

                    manager.update(id, inventory_finded);
                    System.out.println("Cap nhat so luong thanh cong!");

                } else {
                    System.out.println("Khong tim thay ma san pham trong kho hang !");

                }
                System.out.print("An Enter de tiep....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.print("Nhap ma san pham trong kho: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();
                manager.delete(id);

                System.out.print("An Enter de tiep....");
                scanner.nextLine();
            } else if (option == 0) {
                Inventory.resetId();
                InventoryManager.saveFile();
                break;
            } else {
                System.out.println("Tuy chon khong hop le. Vui long nhap lai");
                continue;
            }
        }
    }

}
