package ui;

import java.util.List;
import java.util.Scanner;

import model.Customer;
import repository.CustomerRepository;
import services.CustomerManager;

public class CustomerUI {
    public static boolean checkPhone(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void handleCustomer(Scanner scanner, List<Customer> customers) {
        CustomerManager manager = new CustomerManager();
        String file_path = "src/data/customer_data.txt";
        while (true) {
            Menu.menuCustomer();
            System.out.print("Nhập tuỳ chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            String name;
            System.out.println("Nhập họ và tên: ");
            if (option == 1) {
                while (true) {
                    name = scanner.nextLine();
                    if (name.matches(".*\\d+.*")) {
                        System.out.println("Vui lòng nhập lại");
                    } else {
                        break;
                    }
                }

                System.out.print("Nhập địa chi: ");
                String address = scanner.nextLine();

                String phone;
                System.out.println("Nhập số điện thoại : ");
                while (true) {
                    phone = scanner.nextLine();
                    if (!checkPhone(phone)) {
                        System.out.println("Số điện thoại không hợp lệ. Vui lòng chỉ sử dụng các chữ số");
                    } else if (phone.length() != 10 && checkPhone(phone)) {
                        System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập chính xác 10 chữ số");
                    } else {
                        break;
                    }
                }

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
                CustomerManager.saveFile();
                System.out.println("Thông tin khách hàng đã lưu vào thành công");

            } else if (option == 0) {
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }

        }
    }

}
