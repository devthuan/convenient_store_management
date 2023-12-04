package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Inventory;
import model.Order;
import model.Product;
import repository.InventoryRespository;
import ui.InventoryUI;
import validation.InpuValidator;

public class InventoryManager implements InterfaceCRUD<Inventory> {
    static List<Inventory> inventories = new ArrayList<>();
    static String file_path = "src/data/inventory_data.txt";

    public static void startInventoryManager(Scanner scanner) {
        InventoryUI.handleInventory(scanner, inventories);
    }

    public static void exportInventories(List<Inventory> inventories) {
        if (inventories != null) {

            System.out.println("===================================");
            System.out.println("    DANH SACH SAN PHAM TRONG KHO   ");
            System.out.println("===================================");
            System.out.println(
                    "-------+---------------+--------------+------------+------------------+-----------------+-----------------+");
            System.out.println(
                    "|  ID  |     Ten       |     Gia      |  So luong  |   han san pham   |  Ngay nhap kho  |  Ngay cap nhat  |");
            System.out.println(
                    "-------+---------------+--------------+------------+------------------+-----------------+-----------------+");
            for (Inventory inventory : inventories) {

                System.out.println(
                        String.format("| %4s | %13s | %12s | %10s | %16s | %15s | %15s |",
                                inventory.getId(),
                                inventory.getProduct().getName(),
                                inventory.getProduct().getPrice(),
                                inventory.getProduct().getQuantity(),
                                InpuValidator.formatLocalDate(inventory.getProduct().getExpire()),
                                InpuValidator.formatLocalDate(inventory.getInputDate()),
                                inventory.getLastUpdate() == null ? inventory.getLastUpdate()
                                        : InpuValidator.formatLocalDate(inventory.getLastUpdate())));
            }
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------");

            System.out.println();

        } else {
            System.out.println("Khong co du lieu nao!");
        }

    }

    public static void exportInventory(Inventory inventory) {
        if (inventories != null) {

            System.out.println("===================================");
            System.out.println("    DANH SACH SAN PHAM TRONG KHO   ");
            System.out.println("===================================");
            System.out.println(
                    "-------+---------------+--------------+------------+------------------+-----------------+-----------------+");
            System.out.println(
                    "|  ID  |     Ten       |     Gia      |  So luong  |   han san pham   |  Ngay nhap kho  |  Ngay cap nhat  |");
            System.out.println(
                    "-------+---------------+--------------+------------+------------------+-----------------+-----------------+");

            System.out.println(
                    String.format("| %4s | %13s | %12s | %10s | %16s | %15s | %15s |",
                            inventory.getId(),
                            inventory.getProduct().getName(),
                            inventory.getProduct().getPrice(),
                            inventory.getProduct().getQuantity(),
                            inventory.getProduct().getExpire(),
                            inventory.getInputDate(),
                            inventory.getLastUpdate()));

            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------");

            System.out.println();

        } else {
            System.out.println("Khong co du lieu nao!");
        }

    }

    public static void saveFile() {
        InventoryRespository.writeInventoriesToFile(inventories, file_path);
        inventories.clear();

    }

    public static void readFile() {
        List<Inventory> inventories_in_file = InventoryRespository.readFileInventory(file_path);

        // Xóa danh sách sản phẩm hiện tại trước khi thêm sản phẩm từ tệp
        inventories.clear();
        if (inventories_in_file != null) {
            for (Inventory inventory : inventories_in_file) {
                inventories.add(inventory);
            }

        }
    }

    @Override
    public void create(Inventory inventory) {
        inventories.add(inventory);
    }

    @Override
    public Inventory read(int id) {
        for (Inventory inventory : inventories) {
            if (inventory.getId() == id) {
                return inventory;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Inventory updated_inventory) {
        for (Inventory inventory : inventories) {
            if (inventory.getId() == id) {
                inventory.setProduct(updated_inventory.getProduct());
                inventory.setLastUpdate(LocalDate.now());
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (Inventory inventory : inventories) {
            if (inventory.getId() == id) {
                inventories.remove(inventory);
                System.out.println("Da xoa san pham " + id + " thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay vat pham trong kho !");
        return;
    }

    @Override
    public Inventory search(int id) {
        for (Inventory inventory : inventories) {
            if (inventory.getId() == id) {
                return inventory;
            }
        }
        return null;
    }

}
