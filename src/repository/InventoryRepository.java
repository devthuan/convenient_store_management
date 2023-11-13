package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import model.Inventory;


public class InventoryRepository {
    
    static String file_path = "convenient_store_management/src/data/inventory_data.txt";
       public static Inventory readInventoryFromFile(String file_path ) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String[] infor_product = data[0].split(",");
                int product_id = Integer.parseInt(infor_product[0]);
                String product_name = infor_product[1];
                int quantity = Integer.parseInt(infor_product[2]);
                LocalDate last_update = LocalDate.parse(infor_product[3]);

                inventory.add(new Inventory(product_id, product_name, quantity, last_update));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void writeInventoryToFile(Inventory product, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {

            writer.write(
                    inventory.getProduct_id() + "," +
                    inventory.getProduct_name() + "," +
                    inventory.getQuantity() + "," +
                    inventory.getLast_update() + ",");
            }
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
