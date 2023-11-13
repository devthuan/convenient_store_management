package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Store;
import model.InterfaceCRUD;
import repository.StoreReposiotitory;
import ui.StoreUI;

public class StoreManager implements InterfaceCRUD<Store> {

    static List<Store> stores = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String file_path = "convenient_store_management/src/data/store_data.txt";

    public static void startStoreManager(Scanner scanner) {
        StoreUI.handleStore(scanner, stores);
    }

    public static void saveFile() {
        StoreRepository.writeStoresToFile(stores, file_path);
        stores.clear();

    }

    public static void readFile() {
        List<Store> stores_in_file = StoreRepository.readFileStore(file_path);
        stores.clear();
        if (stores_in_file != null) {
            for (Store store : stores_in_file) {
                stores.add(store);
            }

        }
    }

@Override
    public void create(Store store) {
        stores.add(store);

    }
@Override
    public static void printAllStores() {
        if (stores.isEmpty()) {
            System.out.println("Khong co cua hang nao.");
        } else {
            for (Store store : stores) {
                System.out.println(store);
            }
        }
    }

    public static void editStore() {
        System.out.println("Nhap id cua ahng can chinh sua:");
        String id = scanner.nextLine();
        Store store = search(id);
        if (store != null) {
            System.out.println(store);
            System.out.println("Nhap ID, Ten, dia chi, SDT, QLCH moi:");
            String newId = scanner.nextLine();
            String newName = scanner.nextLine();
            String newAddress = scanner.nextLine();
            String newPhone = scanner.nextLine();
            String newManager = scanner.nextLine();
            // Cập nhật các thuộc tính cho store
            store.setStore_idd(newId);
            store.setStore_name(newName);
            store.setStore_address(newAddress);
            store.setStore_phone(id);
            store.setStore_phone(newPhone);
            store.setStore_manager(newManager);
            System.out.println("Đa cap nhap thong tin cua hang");
        } else {
            System.out.println("Khong co cua hang can tim");
        }
    }
    

    @Override
    public void delete(int id) {
        Store storeToRemove = search(id);
        if (storeToRemove != null) {
            stores.remove(storeToRemove);
            System.out.println("Đa xoa cua hang thanh cong.");
        } else {
            System.out.println("Khong tim thay cua hang.");
        }
    }

    @Override
    public Store search(int id) {
        return (Store) read(id);
    }

}