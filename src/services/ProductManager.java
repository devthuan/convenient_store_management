package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Product;
import ui.ProductUI;

public class ProductManager implements InterfaceCRUD<Product> {
    static List<Product> products = new ArrayList<>();

    public static void startProductManager(Scanner scanner) {
        ProductUI.handleProduct(scanner, products);
    }

    public static void exportAllEmployee(List<Product> products) {
        if (products != null) {
            System.out.println("===================================");
            System.out.println("         DANH SÁCH SẢN PHẨM        ");
            System.out.println("===================================");
            System.out.println("-------+---------------------+-------------+-------------------");
            System.out.println("|  ID  |     Tên sản phẩm    |  Giá        |  Mô tả sản phẩm  |");
            System.out.println("-------+---------------------+-------------+------------------+");
            for (Product product : products) {

                System.out.println(
                        String.format("| %4s | %19s | %11s | %16s |",
                                product.getId(),
                                product.getName(),
                                product.getPrice(),
                                product.getDescription()));
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println();

        } else {
            System.out.println("Không có dữ liệu nào!");
        }
    }

    public static void exportProduct(Product product) {
        System.out.println("===================================");
        System.out.println("Thông tin sản phẩm");
        System.out.println("===================================");
        System.out.println("Mã sản phẩm    : " + product.getId());
        System.out.println("Tên sản phẩm   : " + product.getName());
        System.out.println("Giá            : " + formatPrice(product.getPrice())); // Sử dụng hàm formatPrice
        System.out.println("Mô tả sản phẩm : " + product.getDescription());
        System.out.println("-----------------------------------");
    }

    // Hàm để định dạng giá sản phẩm thành số có dấu phẩy ngăn cách hàng nghìn
    private static String formatPrice(double price) {
        return String.format("%.2f VND", price);
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
        return null; // Trả về null nếu không tìm thấy sản phẩm
    }

    @Override
    public void update(int id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == id) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setDescription(updatedProduct.getDescription());
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

            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + id);

    }

    @Override
    public Product search(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        System.out.println("Không tìm sản phẩm có mã " + id);
        return null;
    }

}
