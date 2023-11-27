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
import model.Categories.Drinks;
import model.Categories.Food;
import model.Strategy.VATCalculationStrategy;
import model.Strategy.payment.CardPayment;
import model.Strategy.payment.CashPayment;
import model.Strategy.payment.MomoPayment;
import model.Strategy.payment.PaymentStrategy;
import repository.ProductRespository;
import services.OrderManager;
import services.ProductManager;

public class OrderUI extends ProductUI {
    static String file_path = "convenient_store_management/src/data/product_data.txt";

    public static PaymentStrategy choosePaymentMethod(Scanner scanner) {
        System.out.println("1. Thẻ tính dụng");
        System.out.println("2. Momo");
        System.out.println("3. Tiền mặt");

        System.out.print("Chọn phương thức thanh toán: ");
        int choice_payment = scanner.nextInt();
        scanner.nextLine();

        switch (choice_payment) {
            case 1:
                return new CardPayment();
            case 2:
                return new MomoPayment();
            default:
                return new CashPayment();
        }
    }

    private static Product updateProductDetails(Scanner scanner, Product product) {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (product != null && product != null) {
            // Product selectedProduct = order.getProducts().get(0); // Chọn sản phẩm đầu
            // tiên trong đơn hàng

            if (product instanceof Drinks) {
                Drinks drink = (Drinks) product;
                return new Drinks(name, price, quantity, drink.getExpire(), drink.getContainsAlcohol(),
                        drink.getCategory());
            } else if (product instanceof Food) {
                Food food = (Food) product;
                return new Food(name, price, quantity, food.getExpire(), food.getCategory());
            } else {
                System.out.println("Loại sản phẩm không được hỗ trợ.");
            }
        } else {
            System.out.println("Đơn hàng không hợp lệ hoặc không có sản phẩm.");
        }

        return null; // Trả về null nếu có lỗi hoặc không thể xác định được loại sản phẩm
    }

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
                System.out.print("Nhập tên khách hàng: ");
                String name_customer = scanner.nextLine();
                Customer customer = new Customer(name_customer);

                List<Product> products = new ArrayList<>();
                List<Product> products_in_file = ProductRespository.readFileProduct(file_path);
                ProductManager.exportAllProducts(products_in_file);

                while (true) {
                    System.out.print("Chọn mã sản phẩm: ");
                    int id_product = scanner.nextInt();
                    scanner.nextLine();

                    for (Product product : products_in_file) {
                        if (product.getId() == id_product) {
                            System.out.print("Nhập số lượng: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();

                            Product add_product;

                            if (product instanceof Drinks) {
                                Drinks drinks = (Drinks) product;
                                add_product = new Drinks(drinks.getName(), drinks.getPrice(), quantity,
                                        drinks.getExpire(), drinks.getContainsAlcohol(), drinks.getCategory());
                            } else {
                                Food food = (Food) product;
                                add_product = new Food(food.getName(), food.getPrice(), quantity,
                                        food.getExpire(), food.getCategory());

                            }

                            products.add(add_product);
                        }
                    }
                    System.out.print("Có tiếp tục mua hàng không (y/n): ");
                    String continueShopping = scanner.nextLine();
                    if (!continueShopping.equals("y")) {
                        break; // Kết thúc vòng lặp nếu người dùng không muốn tiếp tục mua hàng
                    }
                }

                PaymentStrategy payment_method = choosePaymentMethod(scanner);

                Employee employee = new Employee("Hoang Thanh Duc");
                LocalDate order_date = LocalDate.now();

                Transaction transaction = new Transaction(payment_method);

                Order new_order = new Order(products, order_date, customer, employee, transaction,
                        new VATCalculationStrategy(8));

                manager.create(new_order);
                System.out.println("Đã tạo đơn hàng thành công.");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 2) {
                if (orders.isEmpty()) {
                    System.out.println("Không có đơn hàng nào.");
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
                    // System.out.print("Nhập phương thức thanh toán: ");
                    // String payment_method = scanner.nextLine();

                    PaymentStrategy payment_method = choosePaymentMethod(scanner);

                    LocalDate updated_date = LocalDate.now();
                    Customer customer_updated = new Customer(name_customer);
                    Employee employee_updated = new Employee(name_employee);
                    Transaction transaction_updated = new Transaction(payment_method);
                    List<Product> updated_products = new ArrayList<>();

                    for (int i = 0; i < order_finded.getProducts().size(); i++) {

                        System.out.println("Sửa sản phẩm thứ " + (i + 1) + " trong đơn hàng");

                        Product new_product = updateProductDetails(scanner,
                                order_finded.getProducts().get(i));
                        updated_products.add(new_product);
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
