package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Inventory;
import repository.InventoryRepository;
import ui.InventoryUI;


public class InventoryManager {
    
    static List<Inventory> prods = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String file_path = "convenient_store_management/src/data/inventory_data.txt";

    public static void startInventoryManager() {
        InventoryUI.handleInventory(scanner, prods);
    };
    
    public static void readFile() {
        List<Inventory> data_inventory_in_file = InventoryRepository.readFileInventory(file_path);

        prods.clear();
        for (Inventory prod : data_inventory_in_file) {
            prods.add(prod);
        }
    }
    
    public static void saveFile() {
        InventoryRepository.writeInventoryToFile( prods, file_path);
        prods.clear();
    }

    
    public void create(Inventory prod) {
        prods.add(prod);
    }//Them san pham moi vao kho

    public void update(String id, Inventory update_prod) {
        for (Inventory prod : prods) {
            if (prod.getId() == id) {
                prod.setQuant(update_prod.getQuant());
                prod.setLast_update(update_prod.getLast_update());
                return;
            }
            
        }
    }//Cap nhat thong tin san pham trong kho

    public void delete(String id) {
        for (Inventory prod : prods) {
            if (prod.getId() == id) {
                prods.remove(prod);
                System.out.println("Đa xoa san pham co " + id + " thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay san pham can xoa !!!");

    }//Xoa san pham trong kho theo id

    public Inventory search(String id) {
        for (Inventory prod : prods) {
            if (prod.getId() == id) {
                
            return prod;
            }
            
        }
        return null;
    }//Tim kiem san pham trong kho



    public static void exportprod(Inventory prod) {
        System.out.println("------------------------------------------------");
        System.out.println("Ma san pham    : " + prod.getId());
        System.out.println("Ten san pham   : " + prod.getName());
        System.out.println("So luong       : " + prod.getQuant());
        System.out.println("Ngay nhap kho  : " + prod.getLast_update());
        System.out.println("------------------------------------------------");
    }//XUAT 1 SAN PHAM

    public static void exportInventory(List<Inventory> prods) {

            System.out.println("===================================================");
            System.out.println("                DANH SACH SAN PHAM                    ");
            System.out.println("===================================================");
            System.out.println("-------+---------------------+-----");
            System.out.println("|  ID  |      TEN      | SO LUONG | NGAY NHAP KHO |");
            System.out.println("-------+---------------------+---------------------");
            for (Inventory prod : prods) {
                System.out.println(
                        String.format("| %4s | %13s | %8s | %13s |",
                                prod.getId(),
                                prod.getName(),
                                prod.getQuant(),
                                prod.getLast_update()));
            }
            System.out.println("---------------------------------------------------");
            System.out.println();
        } //Xuất toàn kho
    }
    



