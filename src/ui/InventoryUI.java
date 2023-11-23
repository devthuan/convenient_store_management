package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Inventory;
import repository.InventoryRepository;
import services.InventoryManager;

public class InventoryUI {
    
public static void handleInventory(Scanner scanner, List<Inventory> prods) {
        InventoryManager manager = new InventoryManager();
         String file_path = "convenient_store_management/src/data/inventory_data.txt";

        while (true) {
            Menu.menuInventory();
            System.out.print("Nhap tuy chon: ");
            int option = scanner.nextInt();
            while((option>5) || (option<0))
            {
                System.out.println("Lua chon khong hop le, vui long chon tu 0->5.");
                option = scanner.nextInt();
            }
           if (option==1) {
            
                    System.out.print("Nhap ma san pham: ");
                    String id = scanner.nextLine();
                    scanner.nextLine();
                    
                    System.out.print("Nhap ten san pham: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap so luong: ");
                    String quant = scanner.nextLine();
                    System.out.print("Nhap ngay nhap kho: ");
                    String last_update =scanner.nextLine();
                    
                    Inventory new_prod = new Inventory( id , name, quant, last_update);
                    manager.create(new_prod);
                    System.out.println("Da them san pham moi vao kho thanh cong.");
                    InventoryRepository.writeProdToFile(new_prod, file_path);
                    System.out.println("An ENTER de tiep tuc....");
                    scanner.nextLine();
               }
               else {
                if (option==2) {
                    System.out.println("Nhap id san pham can xoa:");
                    String id = scanner.nextLine();
                    scanner.nextLine();
                    manager.delete(id);

                    System.out.println("An ENTER de tiep tuc....");
                    scanner.nextLine();
               }
                else {
                    if (option==3) {
                    
                    System.out.print("Nhap id san pham can tim:");
                    String id2 = scanner.nextLine();
                    scanner.nextLine();
                    Inventory prod_finded = manager.search(id2);
                    if(prod_finded != null) {
                       System.out.println("Thong tin san pham.");
                       InventoryManager.exportprod(prod_finded); 
                    }
                    else {
                        System.out.println("Khong tim thay san pham co ma " + id2);
    
                    }
                    System.out.println("An ENTER de tiep tuc....");
                    scanner.nextLine();
                }
                else {
                    if (option==4) {
                    
                    System.out.println("Nhap id san pham:");
                    String id3 = scanner.nextLine();
                    Inventory prod_finded = manager.search(id3);
                    if(prod_finded != null) {
                        System.out.println("Nhap thong tin moi cho san pham.");
                        System.out.print("Nhap so luong: ");
                        String quant = scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("Nhap ngay nhap kho: ");
                        String last_update = scanner.nextLine();
                        scanner.nextLine();
                        

                        Inventory update_prod = new Inventory(quant, last_update);
                        manager.update(id3, update_prod);

                        System.out.print("Cap nhat san pham thanh cong.");
                    } else {
                        System.out.print("Khong tim thay san pham can sua!!!");
    
                    }
    
                    System.out.print("An ENTER de tiep tuc....");
                    scanner.nextLine();


                   }
                else {
                    if(option==5){
                    InventoryManager.exportInventory(prods);
                    System.out.println("An ENTER de tiep tuc....");
                    scanner.nextLine();
                }
                else {
                    if(option==0){
                    System.out.println("Exiting...");
                    BaseEntity.resetId();
                    InventoryManager.saveFile();
                    break;
                }
                else{
                    System.out.println("Tuy chon khong hop le vui long nhap lai!!!");
                    continue;
                }
            }
        }
    }
}
               }
            }
        }
    }

