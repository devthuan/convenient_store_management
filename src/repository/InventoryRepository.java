package repository;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model.Inventory;

public class InventoryRepository {
    
     //  static   String file_path = "convenient_store_management/src/data/inventory_data.txt";
       public static List<Inventory> readFileInventory(String file_path) {
        List<Inventory> prods = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String[] infor_inventory = data[0].split(",");
                String id = infor_inventory[1];
                String name = infor_inventory[1];
                String quant = infor_inventory[2];
                String last_update = infor_inventory[3];
                prods.add(new Inventory(id, name, quant, last_update));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return prods;
    }

     public static void writeInventoryToFile(List<Inventory> prods, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Inventory prod : prods) {
                writer.write(
                        prod.getId() + "," +
                                prod.getName() + "," +
                               prod.getQuant() + "," +
                               prod.getLast_update());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void writeProdToFile(Inventory prod, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {

            writer.write(
                    prod.getId() + "," +
                    prod.getName() + "," +
                    prod.getQuant() + "," +
                    prod.getLast_update());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
