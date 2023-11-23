package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Store;
import model.InterfaceCRUD;
import repository.StoreRepository;
import ui.StoreUI;

public class StoreManager implements InterfaceCRUD<Store> {

    static List<Store> stores = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String file_path = "convenient_store_management/src/data/store_data.txt";

    public static void startStoreManager(Scanner scanner) {
        StoreUI.handleStore(scanner, stores);
    }

    public static void saveFile() {
        StoreRepository.writeStoresToFile(stores,file_path);
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

    public static void exportStore(Store store) {
        System.out.println("------------------------------------------------");
        System.out.println("Ma cua hang    : " + store.getId());
        System.out.println("Ten cua hang   : " + store.getName());
        System.out.println("Dia chi        : " + store.getAddress());
        System.out.println("So dien thoai  : " + store.getPhone());
        System.out.println("Quan li        : " + store.getStore_manager());
        System.out.println("------------------------------------------------");
    }

    public static void exportAllStores(List<Store> stores) {
            System.out.println("======================================================");
            System.out.println("                DANH SACH CUA HANG                 ");
            System.out.println("======================================================");
            System.out.println("-------+---------------------+------------------------");
            System.out.println("| ID |     TEN     |    DIA CHI    |    SDT     |  QUAN LI  |");
            System.out.println("-------+---------------------+------------------------");
            for (Store store : stores) {
                System.out.println(
                        String.format("| %2s | %11s | %13s | %11s | %9s |",
                                store.getId(),
                                store.getName(),
                                store.getAddress(),
                                store.getPhone(),
                                store.getStore_manager()));
            
            System.out.println("-----------------------------------------------------");
            System.out.println();
            }
    }



    @Override
    public void delete(int id) {
        Store storeToRemove = search(id);
        if (storeToRemove != null) {
            stores.remove(storeToRemove);
            System.out.println("Da xoa cua hang thanh cong.");
        } else {
            System.out.println("Khong tim thay cua hang.");
        }
    }

    @Override
    public Store search(int id) {
        for (Store store : stores) {
            if (store.getId() == id) {
                return store;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Store updated_store) {
        
        for (Store store : stores) {
            if (store.getId() == id) {
                store.setPhone(updated_store.getPhone());
                store.setStore_manager(updated_store.getStore_manager());
                return;
            }
            
        }
    }

    @Override
    public Store read(int id) {
        for (Store store : stores) {
            if (store.getId() == id) {
                return store;
            }
        }
        return null;
    }


}