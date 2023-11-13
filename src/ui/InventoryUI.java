package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Inventory;
import model.Product;
import repository.InventoryRespository;
import services.InventoryManager;
import services.ProductManager;

public class InventoryUI {
    
public static void handleInventory(Scanner scanner, List<Inventory> products) {
        InventoryManager manager = new InventoryManager();
        String file_path = "convenient_store_management/src/data/inventory_data.txt";

        while (true) {
            Menu.menuInventory();
            System.out.print("Nhap tuy chon: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            while((option>5) || (option<0))
            {
                System.out.println("Lua chon khong hop le, vui long chon tu 0->5.");
                option = scanner.nextInt();
                scanner.nextLine();
            }
            switch (option) {
                case "1":
                    System.out.println("Nhap id, ten san pham, so luong va ngay nhap kho :");
                    String product_id = scanner.nextLine();
                    String product_name = scanner.nextLine();
                    int quantity = Integer.parseInt(scanner.nextLine());
                    String lastupdate =scanner.nextLine();
                    inventory.add(new product(product_id, product_name, quantity, lastupdate));
                    break;
                case "2":
                    System.out.println("Nhap id san pham can xoa:");
                    product_id = scanner.nextLine();
                    boolean found = false;
                    for (Inventory product : products) {
                        if (inventory.product_id.equals(product_id)) {
                            products.remove(product);
                            writeInventoryToFile( product, file_path);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Khong co san pham can xoa");
                    }
                    break;
                case "3":
                    System.out.println("Enter product id:");
                    product_id = scanner.nextLine();
                    for (Inventory product : products) {
                        if (product.product_id.equals(product_id)) {
                            System.out.println("Ten san pham: " + product.product_name + "- So luong: " + producr.quantity + " - Ngay nhap kho: "  + product.getLast_update);
                            );
                            break;
                        }
                    }
                    break;

                case "4":
                    System.out.println("Nhap id san pham:");
                    product_id = scanner.nextLine();
                    foundproduct = null;
                    for (Inventory product : products) {
                        if (Inventory.product_id.equals(product_id)) {
                            foundproduct = product;
                            break;
                        }
                    }
                    if (foundproduct != null) {
                        System.out.println("Thong tin san pham:");
                        System.out.println(" ID: " + foundproduct.product_id + ", Ten san pham: " + foundproduct.product_name + ", San pham: " + foundproduct.quantity + ", Ngay nhap kho: " + foundproduct.lastupdate);
                        System.out.println("Nhap ten san pham moi, so luong moi, va ngay cap nhat moi :");
                        String product_name = scanner.nextLine();
                        int quantity = Integer.parseInt(scanner.nextLine());
                        String lastupdate = scanner.nextLine();
                        foundproducty.product_name = product_name;
                        foundproduct.quantity = quantity;
                        foundproduct.lastupdate = lastupdate;
                        writeInventoryToFile(product,file_path);
                    } else {
                        System.out.println("Khong co san pham can tim");
                    }
                    break;
                case "5":
                    for (Inventory product : products) {
                        System.out.println(" ID: " product.product_id + ",Ten san pahm: " + product.product_name + ", So luong: " + product.quantity + ", Ngay nhap kho: " + product.lastupdate);
                    }
                    break;
                case "0":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
