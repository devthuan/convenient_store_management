package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Inventory;
import model.Product;
import model.Categories.Food;

public class InventoryRespository {

    public static List<Inventory> readFileInventory(String file_path) {
        List<Inventory> inventories = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int quantity = Integer.parseInt(data[3]);
                String expire = data[4];
                String category = data[5];
                LocalDate input_date = LocalDate.parse(data[6]);

                Product product = new Food(name, price, quantity, expire, category);

                inventories.add(new Inventory(product, input_date));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return inventories;
    }

    public static void writeInventoriesToFile(List<Inventory> inventories, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Inventory inventory : inventories) {
                writer.write(
                        inventory.getId() + "," +
                                inventory.getProduct().getName() + "," +
                                inventory.getProduct().getPrice() + "," +
                                inventory.getProduct().getQuantity() + "," +
                                inventory.getProduct().getExpire() + "," +
                                inventory.getProduct().getCategory() + "," +
                                inventory.getInputDate() + "," +
                                inventory.getLastUpdate());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
