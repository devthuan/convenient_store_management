package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;
import model.Order;
import model.Product;
import model.Transaction;
import model.Categories.Drinks;
import model.Categories.Food;
import model.Strategy.VATCalculationStrategy;
import model.Strategy.payment.MomoPayment;
import model.Strategy.payment.PaymentStrategy;

public class OrderRespository extends ProductRespository {

    public static List<Order> readOrdersToFile(String file_path) {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String[] infor_orders = data[0].split(",");
                int id = Integer.parseInt(infor_orders[0]);
                LocalDate order_date = LocalDate.parse(infor_orders[1]);
                String name_customer = infor_orders[2];

                double total_payment = Double.parseDouble(infor_orders[3]);
                // String payment_method = infor_orders[4];
                PaymentStrategy payment_method = new MomoPayment(); // thêm if else

                String name_employee = infor_orders[5];

                Employee employee = new Employee(name_employee);
                Customer customer = new Customer(name_customer);
                Transaction transaction = new Transaction(total_payment, payment_method);

                List<Product> products = new ArrayList<>();
                String[] infor_products = data[1].split(":");
                for (String product : infor_products) {
                    String[] info_product = product.split(",");
                    String name = info_product[0];
                    double price = Double.parseDouble(info_product[1]);
                    int quantity = Integer.parseInt(info_product[2]);
                    String expire = info_product[3];
                    String category = info_product[4];
                    String description = info_product[5];

                    Product item_product = initProduct(name,
                            price,
                            quantity,
                            LocalDate.parse(expire),
                            category,
                            description);

                    products.add(item_product);
                }
                orders.add(new Order(products, order_date, customer, employee, transaction,
                        new VATCalculationStrategy(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return orders;
    }

    public static void writeOrdersToFile(List<Order> orders, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Order order : orders) {

                writer.write(
                        order.getId() + "," +
                                order.getOrderDate() + "," +
                                order.getCustomer().getName() + "," +
                                order.calculateTotal() + "," +
                                order.getTransaction().getPaymentMethod() + "," +
                                order.getEmployee().getName() + "|");

                for (Product product : order.getProducts()) {
                    String description = (product.getContainsAlcohol() == null) ? null
                            : product.getContainsAlcohol().toString();
                    writer.write(
                            product.getName() + "," +
                                    product.getPrice() + "," +
                                    product.getQuantity() + "," +
                                    product.getExpire() + "," +
                                    product.getCategory() + "," +
                                    description + ":");
                }
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public static void writeOrderToFile(Order order, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {

            writer.write(
                    order.getId() + "," +
                            order.getOrderDate() + "," +
                            order.getCustomer().getName() + "," +
                            order.calculateTotal() + ":");
            for (Product product : order.getProducts()) {
                writer.write(
                        product.getName() + "," +
                                product.getPrice() + "," +
                                product.getQuantity());
            }
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}