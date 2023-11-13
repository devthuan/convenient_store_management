package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Employee;
import model.Store;
import services.StoreManager;

public class StoreUI {
    
public static void handleStore(Scanner scanner, List<Store> stores) {
        StoreManager manager = new StoreManager();

        while (true) {
            menuStore();
            System.out.println("Chọn một tùy chọn:");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Nhập ID, Tên, Địa chỉ, SDT, QLCH:");
                    int store_id = Integer.parseInt(scanner.nextLine());
                    String store_name = scanner.nextLine();
                    String store_address = scanner.nextLine();
                    String store_phone = scanner.nextLine();
                    String store_manager = scanner.nextLine();
                    Store store = new Store(store_id, store_name, store_address, store_phone, store_manager);
                    create(store);
                    break;
                case 2:
                    printAllStores();
                    break;
                case 3:
                    System.out.println("Nhập id cửa hàng cần tìm:");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); 
                    search(searchId);
                    break;
                case 4:
                    editStore();
                    break;
                case 5:
                    System.out.println("Nhập id cửa hàng cần xóa:");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    delete(deleteId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    public static void menuStore() {
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|     THAO TAC VOI CUA HANG     |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Tao cua hang moi           |");
        System.out.println("| 2. Xuat ta ca cua hang        |");
        System.out.println("| 3. Tim cua hang               |");
        System.out.println("| 4. Sua thong tin cua hang     |");
        System.out.println("| 5. Xoa cua hang               |");
        System.out.println("| 0. Thoat va luu thong tin     |");
        System.out.println("+-------------------------------+");
        System.out.println("");
    }


}
