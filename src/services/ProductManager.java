package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Product;
import model.Categories.Drinks;
import repository.ProductRespository;

import ui.ProductUI;
import validation.InpuValidator;

public class ProductManager implements InterfaceCRUD<Product> {
    static List<Product> products = new ArrayList<>();
    static String file_path = "convenient_store_management/src/data/product_data.txt";

    public static void startProductManager(Scanner scanner) {
        ProductUI.handleProduct(scanner, products);
    }

    public static void exportAllProducts(List<Product> products) {
        if (products != null) {
            System.out.println("===================================");
            System.out.println("         DANH SACH SAN PHAM        ");
            System.out.println("===================================");
            System.out.println(
                    "-------+---------------------+-------------+----------------------+----------------------+");
            System.out.println(
                    "|  ID  |     Ten san pham    |     Gia     |    Loai san pham     |     Han su dung      |");
            System.out.println(
                    "-------+---------------------+-------------+----------------------+----------------------+");

            for (Product product : products) {
                String description = "";

                if (product instanceof Drinks) {
                    Drinks drinks = (Drinks) product;
                    description = drinks.getContainsAlcohol() ? "co con" : "khong co con";
                }

                System.out.println(
                        String.format("| %4s | %19s | %11s | %19s |  %19s |",
                                product.getId(),
                                product.getName(),
                                product.getPrice(),
                                product.getCategory() + " " +
                                        description,
                                InpuValidator.formatLocalDate(product.getExpire())));
            }

            System.out.println(
                    "------------------------------------------------------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Khong co du lieu nao!");
        }
    }

    public static void exportProduct(Product product) {
        String description = "";

        if (product instanceof Drinks) {
            Drinks drinks = (Drinks) product;
            description = drinks.getContainsAlcohol() ? "co con" : "khong co con";
        }
        System.out.println("===================================");
        System.out.println("Thong tin san pham");
        System.out.println("===================================");
        System.out.println("Ma san pham    : " + product.getId());
        System.out.println("Ten san pham   : " + product.getName());
        System.out.println("Gia            : " + formatPrice(product.getPrice())); // Sử dụng hàm formatPrice
        System.out.println("Mo ta san pham : " + product.getCategory() + " " + description);
        System.out.println("Han su dung    : " + InpuValidator.formatLocalDate(product.getExpire()));
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
                System.out.println("Da xoa san pham thanh cong.");
                return;
            }
        }

        System.out.println("Khong tim thay san pham co ma " + id);
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
