package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.BaseOrderId;
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
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập số nguyên!");
                scanner.next();
            }
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Nha tên khách hàng: ");
                String name_customer = scanner.nextLine();
                Customer customer = new Customer(name_customer);
                // System.out.print("Nha tên thu ngân: ");
                // String name_employee = scanner.nextLine();
                System.out.print("Nhập phương thức giao dịch: ");
                String payment_method = scanner.nextLine();

                Employee employee = new Employee("Hoang Thanh Duc");
                LocalDate order_date = LocalDate.now();
                Transaction transaction = new Transaction(payment_method);
                List<Product> products = new ArrayList<>();

                products.add(new Product("NumberOne", 10000, 1));
                products.add(new Product("Oshi", 5000, 1));
                Order new_order = new Order(products, order_date, customer, employee, transaction);
                manager.create(new_order);
                System.out.println("Đã tạo đơn hàng thành công.");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 2) {
                if (orders.isEmpty()) {
                    System.out.println("Không có nhân viên nào.");
                } else {
                    OrderManager.exportProducts(orders);

                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 3) {
                System.out.print("Nhập mã sản phẩm: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Order order_finded = manager.search(id);

                if (order_finded != null) {
                    OrderManager.exportProduct(order_finded);
                } else {
                    System.out.println("Không tìm thấy hoá đơn có mã " + id);
                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhập mã sản phẩm: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                manager.delete(id);

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.print("Nhập mã sản phẩm cần chỉnh sửa: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Order order_finded = manager.search(id);

                if (order_finded != null) {

                    System.out.print("Nhập tên khách hàng: ");
                    String name_customer = scanner.nextLine();
                    System.out.print("Nhập tên thu ngân: ");
                    String name_employee = scanner.nextLine();
                    System.out.print("Nhập phương thức thanh toán: ");
                    String payment_method = scanner.nextLine();

                    LocalDate updated_date = LocalDate.now();
                    Customer customer_updated = new Customer(name_customer);
                    Employee employee_updated = new Employee(name_employee);
                    Transaction transaction_updated = new Transaction(payment_method);
                    List<Product> updated_products = new ArrayList<>();

                    for (int i = 1; i <= order_finded.getProducts().size(); i++) {

                        System.out.println("Sửa sản phẩm thứ " + i + " trong đơn hàng");
                        System.out.print("Nhân tên sản phẩm: ");
                        String name = scanner.nextLine();

                        System.out.print("Nhập giá: ");
                        double price = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nhập số lượng: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        updated_products.add(new Product(name, price, quantity));
                    }
                    Order updated_order = new Order(updated_products, updated_date, customer_updated, employee_updated,
                            transaction_updated);
                    manager.update(id, updated_order);
                    System.out.println("Cập nhật đơn hàng thành công!");
                } else {
                    System.out.println("Không tìm thấy mã đơn hàng cần sửa !");

                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 0) {
                BaseOrderId.resetId();
                OrderManager.saveFile();
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }
        }
    }
}
