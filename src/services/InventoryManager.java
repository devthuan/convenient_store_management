package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Inventory;
import repository.InventoryReponsitory;
import ui.InventoryUI;


public class InventoryManager {
    
    static String file_path = "convenient_store_management/src/data/inventory_data.txt";
    public static void startInventoryManager(Scanner scanner) {
        InventoryUI.handleInventory(scanner, inventory);
    };
    List<Inventory> products = new ArrayList<>();
  
    public void addProduct(Inventory product) {
        this.products.add(product);
    }//thêm

    public void updateProduct(Inventory product) {
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).product_id.equals(product.product_id)) {
                this.products.set(i, product);
                break;
            }
        }
    }//sửa
    
    
    public void removeProduct(String product_id) {
        this.products.removeIf(product -> product.product_id.equals(product_id));
    }//xóa
    


    public Inventory searchProduct(String product_id) {
        for (Inventory product : this.products) {
            if (Inventory.product_id.equals(product_id)) {
                return product;
            }
        }
        return null;
    }//tìm kiếm
   
   
    
    public static void exportInventory(List<Inventory> products) {
        if (products != null) {
            System.out.println("===========================================================");
            System.out.println("                     DANH SACH SAN PHAM                    ");
            System.out.println("===========================================================");
            System.out.println("-------+---------------------+-----");
            System.out.println("|  ID  |     TEN       | SO LUONG | NGAY NHAP KHO |");
            System.out.println("-------+---------------------+-----------------------------");
            for (Inventory product : products) {
                System.out.println(
                        String.format("| %4s | %20s | %12s | %20s |",
                                product.product_id,
                                product.product_name,
                                product.quantity,
                                product.lastupdate));
            }
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Không có dữ liệu nào!");
        }
    }//Xuất toàn kho
    


}
