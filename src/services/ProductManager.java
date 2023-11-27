package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Product;
import model.Categories.Drinks;
import repository.ProductRespository;

import ui.ProductUI;

public class ProductManager implements InterfaceCRUD<Product> {
    static List<Product> products = new ArrayList<>();
    static String file_path = "convenient_store_management/src/data/product_data.txt";

    public static void startProductManager(Scanner scanner) {
        ProductUI.handleProduct(scanner, products);
    }

    public static void exportAllProducts(List<Product> products) {
        if (products != null) {
            System.out.println("===================================");
            System.out.println("         DANH SÁCH SẢN PHẨM        ");
            System.out.println("===================================");
            System.out.println(
                    "-------+---------------------+-------------+----------------------+----------------------+");
            System.out.println(
                    "|  ID  |     Tên sản phẩm    |     Giá     |    Loại sản phẩm     |     Hạn sử dụng      |");
            System.out.println(
                    "-------+---------------------+-------------+----------------------+----------------------+");

            for (Product product : products) {
                String description = "";

                if (product instanceof Drinks) {
                    Drinks drinks = (Drinks) product;
                    description = drinks.getContainsAlcohol() ? "có cồn" : "không có cồn";
                }

                System.out.println(
                        String.format("| %4s | %19s | %11s | %19s |  %19s |",
                                product.getId(),
                                product.getName(),
                                product.getPrice(),
                                product.getCategory() + " " +
                                        description,
                                product.getExpire()));
            }

            System.out.println(
                    "------------------------------------------------------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Không có dữ liệu nào!");
        }
    }

    public static void exportProduct(Product product) {
        String description = "";

        if (product instanceof Drinks) {
            Drinks drinks = (Drinks) product;
            description = drinks.getContainsAlcohol() ? "có cồn" : "không có cồn";
        }
        System.out.println("===================================");
        System.out.println("Thông tin sản phẩm");
        System.out.println("===================================");
        System.out.println("Mã sản phẩm    : " + product.getId());
        System.out.println("Tên sản phẩm   : " + product.getName());
        System.out.println("Giá            : " + formatPrice(product.getPrice())); // Sử dụng hàm formatPrice
        System.out.println("Mô tả sản phẩm : " + product.getCategory() + " " + description);
        System.out.println("Hạn sử dụng    : " + product.getExpire());
        System.out.println("-----------------------------------");
    }

    // Hàm để định dạng giá sản phẩm thành số có dấu phẩy ngăn cách hàng nghìn
    private static String formatPrice(double price) {
        return String.format("%.2f VND", price);
    }

    public static void saveFile() {
        ProductRespository.writeProductsToFile(products, file_path);
        products.clear();

    }

    public static void readFile() {
        List<Product> products_in_file = ProductRespository.readFileProduct(file_path);

        // Xóa danh sách sản phẩm hiện tại trước khi thêm sản phẩm từ tệp
        products.clear();
        if (products_in_file != null) {
            for (Product product : products_in_file) {
                products.add(product);
            }

        }
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public Product read(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product updated_product) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == id) {
                product.setName(updated_product.getName());
                product.setPrice(updated_product.getPrice());
                product.setDescription(updated_product.getCategory());
                product.setExpire(updated_product.getExpire());
                // Cập nhật thông tin sản phẩm dựa trên ID
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                System.out.println("Đã xóa sản phẩm thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy sản phẩm có mã " + id);
        return;
    }

    @Override
    public Product search(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
