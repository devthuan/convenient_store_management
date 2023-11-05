package ui;

import java.util.List;
import java.util.Scanner;
import model.BaseEntity;

import model.Customer;
import model.Product;
import repository.CustomerRepository;
import repository.ProductRespository;
import services.CustomerManager;

public class CustomerUI {
    public static void handleCustomer(Scanner scanner, List<Customer> customers) {
        CustomerManager manager = new CustomerManager();
        String file_path = "src/data/customer_data.txt";
        while (true) {
            Menu.menuCustomer();
            System.out.print("Nhập tuỳ chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Nhân tên khách hàng: ");
                String name = scanner.nextLine();

                System.out.print("Nhập địa chi: ");
                String address = scanner.nextLine();

                System.out.print("Nhập số điện thoại: ");
                String phone = scanner.nextLine();

                Customer new_customer = new Customer(name, address, phone);
                manager.create(new_customer);
                customers.add(new_customer);
                CustomerRepository.writeFileCustomer(new_customer, file_path);

                System.out.println("Đã tạo khách hàng thành công.");

            } else if (option == 2) {

                if (customers == null) {
                    System.out.println("Không có khách hàng nào.");
                } else {
                    Customer.exportAllCustomer(customers);

                }

            } else if (option == 3) {

                System.out.print("Nhập mã khách hàng: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Customer result_search = manager.search(id);

                if (result_search != null) {
                    Customer.exportCustomer(result_search);

                } else {
                    System.out.print("Không tìm thấy khách hàng.");
                }
                continue;
            } else if (option == 4) {
                System.out.print("Nhập mã khách hàng: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                manager.delete(id);

            } else if (option == 5) {
                CustomerManager.saveFile();
                System.out.println("Dữ liệu khách hàng đã được lưu vào tệp tin.");
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }

        }
    }

}
