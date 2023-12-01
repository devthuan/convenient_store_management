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
            System.out.print("Nhập tuỳ chọn: ");
            int option = InpuValidator.validateIntInput(scanner);
            scanner.nextLine();

            if (option == 1) {

                Product product = chooseCategory(scanner);
                LocalDate now_date = LocalDate.now();
                Inventory new_item = new Inventory(product, now_date, null);
                manager.create(new_item);

                System.out.println("Đã nhập sản phẩm vào kho thành công.");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();

            } else if (option == 2) {
                if (inventories.isEmpty()) {
                    System.out.println("Kho hàng trống.");
                } else {
                    InventoryManager.exportInventories(inventories);

                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 3) {
                System.out.print("Nhập mã sản phẩm: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();

                Inventory inventory_finded = manager.search(id);

                if (inventory_finded != null) {
                    InventoryManager.exportInventory(inventory_finded);
                } else {
                    System.out.println("Trong kho hàng không có sản phẩm có mã " + id);
                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();

            } else if (option == 4) {
                System.out.print("Nhập mã sản phẩm cần chỉnh sửa: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();

                Inventory inventory_finded = manager.search(id);

                if (inventory_finded != null) {
                    System.out.print("Nhập số lượng sản phẩm: ");
                    int new_quantity = InpuValidator.validateIntInput(scanner);
                    scanner.nextLine();

                    System.out.print("Nhập hạn sử dụng (yyyy-mm-dd): ");
                    LocalDate new_expire = InpuValidator.validateLocalDateInput(scanner);

                    Product product_updated = new Food(inventory_finded.getProduct().getName(),
                            inventory_finded.getProduct().getPrice(), new_quantity,
                            new_expire, inventory_finded.getProduct().getCategory());
                    inventory_finded.setProduct(product_updated);

                    manager.update(id, inventory_finded);
                    System.out.println("Cập nhật số lượng thành công!");

                } else {
                    System.out.println("Không tìm thấy mã sản phẩm kho hàng cần sửa !");

                }
                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.print("Nhập mã sản phẩm trong kho: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();
                manager.delete(id);

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 0) {
                Inventory.resetId();
                InventoryManager.saveFile();
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;
            }
        }
    }

}
