package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Store;


public class StoreReposition {
    
    static String file_path = "convenient_store_management/src/data/store_data.txt";
     public static Store readFileStore(String file_path) {
        Store store = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            store = (Store) objectIn.readObject();
            objectIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return store;
    }

   

        writeStoreToFile(String file_path, Store store) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(store);
            objectOut.close();
            System.out.println("Da ghi du lieu vao file thanh cong. ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        }
    }