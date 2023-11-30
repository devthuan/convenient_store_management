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

public class InventoryRespository extends ProductRespository {

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
                LocalDate expire = LocalDate.parse(data[4]);
                String category = data[5];
                String description = data[6];
                LocalDate input_date = LocalDate.parse(data[7]);
                LocalDate updated_date = data[8].equals("null") ? null : LocalDate.parse(data[8]);

                Product product = initProduct(name, price, quantity, expire, category, description);

                inventories.add(new Inventory(product, input_date, updated_date));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return inventories;
    }

    public static void writeInventoriesToFile(List<Inventory> inventories, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Inventory inventory : inventories) {
                String description = (inventory.getProduct().getContainsAlcohol() == null) ? null
                        : inventory.getProduct().getContainsAlcohol().toString();
                writer.write(
                        inventory.getId() + "," +
                                inventory.getProduct().getName() + "," +
                                inventory.getProduct().getPrice() + "," +
                                inventory.getProduct().getQuantity() + "," +
                                inventory.getProduct().getExpire() + "," +
                                inventory.getProduct().getCategory() + "," +
                                description + "," +
                                inventory.getInputDate() + "," +
                                inventory.getLastUpdate());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
