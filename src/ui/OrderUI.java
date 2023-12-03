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
import validation.InpuValidator;

public class OrderUI extends ProductUI {
    static String file_path = "convenient_store_management/src/data/product_data.txt";

    public static PaymentStrategy choosePaymentMethod(Scanner scanner) {
        System.out.println("1. The tinh dung");
        System.out.println("2. Momo");
        System.out.println("3. Tien mat");

        System.out.print("Chon phuong thuc thanh toan: ");

        while (true) {
            int choice_payment = InpuValidator.validateIntInput(scanner);
            scanner.nextLine();
            if (choice_payment == 1) {
                return new CardPayment();

            } else if (choice_payment == 2) {

                return new MomoPayment();
            } else if (choice_payment == 3) {

                return new CashPayment();
            } else {
                System.out.println("Tuy chon khong hop le. Vui long nhap lai");
                continue;
            }

        }
    }

    private static Product updateProductDetails(Scanner scanner, Product product) {
        System.out.print("Nhap ten san pham: ");
        String name = scanner.nextLine();

        System.out.print("Nhap gia san pham: ");
        int price = InpuValidator.validateIntInput(scanner);
        scanner.nextLine();

        System.out.print("Nhap so luong: ");
        int quantity = InpuValidator.validateIntInput(scanner);
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
                System.out.println("Loai san pham khong duoc ho tro.");
            }
        } else {
            System.out.println("Don hang khong hop le hoac khong co san pham.");
        }

        return null; // Trả về null nếu có lỗi hoặc không thể xác định được loại sản phẩm
    }

    public static void handleOrder(Scanner scanner, List<Order> orders) {
        OrderManager manager = new OrderManager();
        while (true) {
            Menu.menuOrder();
            System.out.print("Nhap tuy chon: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui long nhap so nguyen!");
                scanner.next();
            }
            int option = InpuValidator.validateIntInput(scanner);
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Nhap ten khach hang: ");
                String name_customer = scanner.nextLine();
                Customer customer = new Customer(name_customer);

                List<Product> products = new ArrayList<>();
                List<Product> products_in_file = ProductRespository.readFileProduct(file_path);
                ProductManager.exportAllProducts(products_in_file);

                while (true) {
                    System.out.print("Chon ma san pham: ");
                    int id_product = InpuValidator.validateIntInput(scanner);
                    scanner.nextLine();

                    for (Product product : products_in_file) {
                        if (product.getId() == id_product) {
                            System.out.print("Nhap so luong: ");
                            int quantity = InpuValidator.validateIntInput(scanner);
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
                    System.out.print("Ban co tiep tuc mua hang khong (y/n): ");
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
                System.out.println("Da tao don hang thanh cong.");

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 2) {
                if (orders.isEmpty()) {
                    System.out.println("Không có đơn hàng nào.");
                } else {
                    OrderManager.exportProducts(orders);

                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 3) {
                System.out.print("Nhap ma san pham: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();

                Order order_finded = manager.search(id);

                if (order_finded != null) {
                    OrderManager.exportProduct(order_finded);
                } else {
                    System.out.println("Khong tim thay hoa don co ma " + id);
                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhap ma san pham: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();
                manager.delete(id);

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.print("Nhap ma san pham cần chỉnh sửa: ");
                int id = InpuValidator.validateIntInput(scanner);
                scanner.nextLine();

                Order order_finded = manager.search(id);

                if (order_finded != null) {

                    System.out.print("Nhap ten khach hang: ");
                    String name_customer = scanner.nextLine();
                    System.out.print("Nhap ten thu ngan: ");
                    String name_employee = scanner.nextLine();

                    PaymentStrategy payment_method = choosePaymentMethod(scanner);

                    LocalDate updated_date = LocalDate.now();
                    Customer customer_updated = new Customer(name_customer);
                    Employee employee_updated = new Employee(name_employee);
                    Transaction transaction_updated = new Transaction(payment_method);
                    List<Product> updated_products = new ArrayList<>();

                    for (int i = 0; i < order_finded.getProducts().size(); i++) {

                        System.out.println("Sua san pham thu " + (i + 1) + " trong don hang");

                        Product new_product = updateProductDetails(scanner,
                                order_finded.getProducts().get(i));
                        updated_products.add(new_product);
                    }
                    Order updated_order = new Order(updated_products, updated_date, customer_updated, employee_updated,
                            transaction_updated);
                    manager.update(id, updated_order);
                    System.out.println("Cap nhat don hang thanh cong!");
                } else {
                    System.out.println("Khong tim thay ma don hang can sua !");

                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 0) {
                BaseOrderId.resetId();
                OrderManager.saveFile();
                break;
            } else {
                System.out.println("Tuy chon khong hop le. Vui long nhap lai");
                continue;

            }
        }
    }

}
