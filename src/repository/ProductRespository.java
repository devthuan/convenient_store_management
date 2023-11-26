package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Categories.Drinks;
import model.Categories.Food;

public class ProductRespository {

    public static Product initProduct(String name,
            double price,
            int quantity,
            String expire,
            String category,
            String description) {

        if (description.equals("null")) {

            return new Food(name, price, quantity, expire,
                    category);
        } else {
            return new Drinks(name, price, quantity, expire, Boolean.parseBoolean(description),
                    category);
        }

    }

    public static List<Product> readFileProduct(String file_path) {
        List<Product> productList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    int quantity = Integer.parseInt(data[3]);
                    String expire = data[4];
                    String category = data[5];
                    String description = data[6];

                    Product product = initProduct(name,
                            price,
                            quantity,
                            expire,
                            category,
                            description);

                    productList.add(product);
                } else {
                    // Handle data format errors
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file reading errors
        }

        return productList;
    }

    public static void writeFileProduct(Product product, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            writer.write(product.getId() + "," +
                    product.getName() + "," +
                    product.getPrice() + "," +
                    product.getCategory());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public static void writeProductsToFile(List<Product> products, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Product product : products) {
                String description = (product.getContainsAlcohol() == null) ? null
                        : product.getContainsAlcohol().toString();

                writer.write(product.getId() + "," +
                        product.getName() + "," +
                        product.getPrice() + "," +
                        product.getQuantity() + "," +
                        product.getExpire() + "," +
                        product.getCategory() + "," +
                        description);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ theo ý của bạn
        }
    }

}
