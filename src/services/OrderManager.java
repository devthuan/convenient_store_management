package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.InterfaceCRUD;
import model.Order;
import model.Product;
import ui.OrderUI;

public class OrderManager implements InterfaceCRUD<Order> {
    static List<Order> orders = new ArrayList<>();
    static Customer customer = new Customer();
    static Employee employee = new Employee();

    public static void startOrderManager(Scanner scanner) {
        OrderUI.handleOrder(scanner, orders);
    };
    

    public static void exportProduct(Order order) {
        System.out.println("===================================");
        System.out.println("                HOÁ ĐƠN");
        System.out.println("===================================");
        System.out.println();
        System.out.println("Mã đơn hàng    : " + order.getId());
        System.out.println("Ngày tạo đơn   : " + order.getOrderDate());
        System.out.println("Tên Khách hàng : " + order.getCustomer().getName());
        System.out.println("------------------+-------------+------------");
        System.out.println("|  Tên sản phẩm   |     giá     | số lượng  |");
        System.out.println("------------------+-------------+------------");
        for (Product product : order.getProducts()) {
            System.out.println(
                    String.format("| %15s | %11s | %9s |",
                            product.getName(),
                            product.getPrice(), // Sử dụng hàm formatPrice
                            product.getQuantity()));

        }
        System.out.println("--------------------------------------------");
        System.out.println("Tổng số tiền   : " + formatPrice(order.calTotalAmount()));
        System.out.println("Thu ngân       : " + order.getEmployee().getName());

        System.out.println("-----------------------------------");
    }

    private static String formatPrice(double price) {
        return String.format("%,.2f VND", price).replace(",", ",");
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
    public void update(int id, Order entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Order search(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
