package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductRespository {

    public static List<Product> readFileProduct(String file_path) {
        List<Product> productList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    String description = data[3];

                    Product product = new Product(id, name, price, description);
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
                    product.getDescription());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public static void writeProductsToFile(List<Product> products, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Product product : products) {
                writer.write(product.getId() + "," +
                        product.getName() + "," +
                        product.getPrice() + "," +
                        product.getDescription());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ theo ý của bạn
        }
    }

}
