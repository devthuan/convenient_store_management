package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Order;
import model.Product;
import repository.OrderRespository;
import ui.OrderUI;
import validation.InpuValidator;

public class OrderManager implements InterfaceCRUD<Order> {
    static List<Order> orders = new ArrayList<>();
    static String file_path = "src/data/order_data.txt";

    public static void startOrderManager(Scanner scanner) {
        OrderUI.handleOrder(scanner, orders);
    };

    public static void exportProducts(List<Order> orders) {
        for (Order order : orders) {

            System.out.println("===================================");
            System.out.println("                HOA DON");
            System.out.println("===================================");
            System.out.println();
            System.out.println("Ma hoa don        : " + order.getId());
            System.out.println("Ngay tao don       : " + InpuValidator.formatLocalDate(order.getOrderDate()));
            System.out.println("Ten khach hang     : " + order.getCustomer().getName());
            System.out.println("Danh sach san pham");
            System.out.println("------------------+-------------+------------");
            System.out.println("|  Ten san pham   |     Gia     | So luong  |");
            System.out.println("------------------+-------------+------------");
            for (Product product : order.getProducts()) {
                System.out.println(
                        String.format("| %15s | %11s | %9s |",
                                product.getName(),
                                product.getPrice(), // Sử dụng hàm formatPrice
                                product.getQuantity()));

            }
            System.out.println("--------------------------------------------");
            System.out.println("Thue VAT              : 8%");
            System.out.println("Tong so tien          : " + formatPrice(order.calculateTotal()));
            System.out.println("Phuong thuc thanh toan: " + order.getTransaction().getPaymentMethod());
            System.out.println("Thu ngan              : " + order.getEmployee().getName());

            System.out.println("--------------------------------------------");
        }
    }

    public static void exportProduct(Order order) {

        System.out.println("===================================");
        System.out.println("                HOA DON");
        System.out.println("===================================");
        System.out.println();
        System.out.println("Ma hoa don        : " + order.getId());
        System.out.println("Ngay tao don       : " + InpuValidator.formatLocalDate(order.getOrderDate()));
        System.out.println("Ten khach hang     : " + order.getCustomer().getName());
        System.out.println("Danh sach san pham");
        System.out.println("------------------+-------------+------------");
        System.out.println("|  Ten san pham   |     Gia     | So luong  |");
        System.out.println("------------------+-------------+------------");
        for (Product product : order.getProducts()) {
            System.out.println(
                    String.format("| %15s | %11s | %9s |",
                            product.getName(),
                            product.getPrice(), // Sử dụng hàm formatPrice
                            product.getQuantity()));

        }
        System.out.println("--------------------------------------------");
        System.out.println("Thue VAT              : 8%");
        System.out.println("Tong so tien          : " + formatPrice(order.calculateTotal()));
        System.out.println("Phuong thuc thanh toan: " + order.getTransaction().getPaymentMethod());
        System.out.println("Thu ngan              : " + order.getEmployee().getName());

        System.out.println("--------------------------------------------");
    }

    private static String formatPrice(double price) {
        return String.format("%,.2f VND", price).replace(",", ",");
    }

    public static void readFile() {
        List<Order> data_orders_in_file = OrderRespository.readOrdersToFile(file_path);

        orders.clear();
        for (Order order : data_orders_in_file) {
            orders.add(order);
        }
    }

    public static void saveFile() {
        OrderRespository.writeOrdersToFile(orders, file_path);
    }

    @Override
    public void create(Order order) {
        orders.add(order);
    }

    @Override
    public Order read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void update(int id, Order updated_order) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.setCustomer(updated_order.getCustomer());
                order.setEmployee(updated_order.getEmployee());
                order.setTransaction(updated_order.getTransaction());
                order.setProducts(updated_order.getProducts());
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                orders.remove(order);
                System.out.println("Da xoa hoa " + id + " thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim ma hoa don can xoa !!!");
        return;
    }

    @Override
    public Order search(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

}
