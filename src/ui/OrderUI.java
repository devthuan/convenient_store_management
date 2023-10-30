package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.Order;
import model.Product;
import model.Transaction;
import services.OrderManager;

public class OrderUI {

    public static void handleOrder(Scanner scanner, List<Order> orders) {
        OrderManager manager = new OrderManager();
        while (true) {
            Menu.menuOrder();
            System.out.print("Nhập tuỳ chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Nha tên khách hàng: ");
                String name_customer = scanner.nextLine();
                Customer customer = new Customer(name_customer);

                // System.out.print("Nha tên thu ngân: ");
                // String name_employee = scanner.nextLine();
                Employee employee = new Employee("Hoang Thanh Duc");

                LocalDate order_date = LocalDate.now();

                System.out.print("Nhập phương thức giao dịch: ");
                String payment_method = scanner.nextLine();
                Transaction transaction = new Transaction(payment_method);

                List<Product> products = new ArrayList<>();
                products.add(new Product("NumberOne", 10000, 1));
                products.add(new Product("Oshi", 5000, 1));

                Order new_order = new Order(products, order_date, customer, employee, transaction);
                manager.create(new_order);
                System.out.print("Đã tạo đơn hàng thành công.");

            } else if (option == 2) {
                if (orders.isEmpty()) {
                    System.out.println("Không có nhân viên nào.");
                } else {
                    for (Order order : orders) {

                        OrderManager.exportProduct(order);
                    }

                }

            } else if (option == 0) {
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }
        }
    }
}
