package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Store;


public class StoreRepository {
    
   // static String file_path = "convenient_store_management/src/data/store_data.txt";
     public static List<Store> readFileStore(String file_path) {
        List<Store> StoreList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String address = data[2];
                    String phone = data[3];
                    String manager = data[4];
                    Store store = new Store(id, name, address, phone, manager);
                    StoreList.add(store);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return StoreList;
    }
    

   

            public static void writeFileStore(Store store, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            writer.write(store.getId() + "," +
                    store.getName() + "," +
                    store.getAddress() + "," +
                    store.getPhone() + "," +
                    store.getStore_manager());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void writeStoresToFile(List<Store> stores, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Store store : stores) {
                writer.write(store.getId() + "," +
                    store.getName() + "," +
                    store.getAddress() + "," +
                    store.getPhone() + "," +
                    store.getStore_manager());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}