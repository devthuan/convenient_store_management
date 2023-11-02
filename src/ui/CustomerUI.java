package ui;

import java.util.List;
import java.util.Scanner;

import model.Customer;
import repository.CustomerRepository;
import services.CustomerManager;

public class CustomerUI {
    public static void handleCustomer(Scanner scanner, List<Customer> customers) {
        CustomerManager manager = new CustomerManager();

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
                customers.add(new_customer);

                System.out.println("Đã tạo khách hàng thành công.");

            } else if (option == 2) {
                if (customers.isEmpty()) {
                    System.out.println("Không có khách hàng nào.");
                } else {
                    Customer.exportAllEmployee(customers);

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
                String file_path = "convenient_store_management/src/data/customer_data.txt";
                for (Customer customer : customers) {
                    CustomerRepository.writeFile(customer, file_path);
                }
                System.out.println("Đã lưu thông tin vào file thành công.");

            } else if (option == 0) {
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }

        }
    }

}
