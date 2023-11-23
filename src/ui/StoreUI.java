package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import repository.StoreRepository;
import model.Store;
import services.StoreManager;

public class StoreUI {
    
public static void handleStore(Scanner scanner, List<Store> stores) {
        StoreManager manager = new StoreManager();
        String file_path = "convenient_store_management/src/data/store_data.txt";
        while (true) {
            Menu.menuStore();
            System.out.print("Chon mot tuy chon:");
            int option = scanner.nextInt();
            scanner.nextLine();
            if(option==1){
                System.out.println("Nhap thong tin cho cua hang.");
                System.out.print("Nhap ten: ");
                    String name = scanner.nextLine();
                System.out.print("Nhap dia chi: ");
                    String address = scanner.nextLine();
                System.out.print("Nhap so dien thoai: ");
                    String phone = scanner.nextLine();
                System.out.print("Nhap ten Quan ly: ");
                    String store_manager = scanner.nextLine();
                    Store new_store = new Store( name, address, phone, store_manager);
                    manager.create(new_store);
                   
                StoreRepository.writeFileStore(new_store,file_path);
                System.out.println("Tao cua hang moi thanh cong.");

                System.out.print("An ENTER de tiep tuc....");
                scanner.nextLine();
                } else {
                    if(option==2){
                            StoreManager.exportAllStores(stores);
                             System.out.println("An ENTER de tiep tuc....");
                            scanner.nextLine();
                    } 
                    else { 
                        if(option==3){
                           System.out.print("Nhap ma cua hang: ");
                            int id = scanner.nextInt();
                           scanner.nextLine();

                           Store store_finded = manager.search(id);
                              if (store_finded != null) {
                           StoreManager.exportStore(store_finded);
                             } else {
                               System.out.println("Khong tim thay cua hang co ma " + id);

                }

                            System.out.print("An ENTER de tiep tuc....");
                             scanner.nextLine();
                        } else {
                            if(option==4) {
                                System.out.print("Nhap ma cua hang cua chinh sua thong tin: ");
                                 int id = scanner.nextInt();
                                   scanner.nextLine();

                                 Store store_finded = manager.search(id);

                                 if (store_finded != null) {
                                System.out.println("Nhap thong tin moi cho cua hang. ");
                                System.out.print("Nhap so dien thoai: ");
                                String phone = scanner.nextLine();
                                scanner.nextLine();
                                System.out.print("Nhap ten Quan ly: ");
                                 String store_manager = scanner.nextLine();
                                 scanner.nextLine();

                                  Store update_store = new Store(phone, store_manager);

                                  manager.update(id, update_store);

                                   System.out.print("Cap nhat cua hang thanh cong.");

                                 } else {
                                      System.out.print("Khong tim thay cua hang can sua!!!");

                                        }

                                 System.out.print("An ENTER de tiep tuc....");
                                   scanner.nextLine();
                            } else {
                                 if(option==5) {
                                   System.out.print("Nhap ma cua hang can xoa: ");
                                      int id = scanner.nextInt();
                                      scanner.nextLine();

                                      manager.delete(id);

                                     System.out.print("An ENTER de tiep tuc....");
                                     scanner.nextLine();
                                    }
                                    else {
                                     if(option==0) {
                                        BaseEntity.resetId();
                                        StoreManager.saveFile();
                                         break;
                    }
                 else {
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


