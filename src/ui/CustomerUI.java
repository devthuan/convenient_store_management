package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Customer;
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
        while (true) {
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
                manager.create(new_customer);

                System.out.println("Đã tạo khách hàng thành công.");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 2) {

                if (customers.isEmpty()) {
                    System.out.println("Không có khách hàng nào.");
                } else {
                    CustomerManager.exportAllEmployee(customers);

                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 3) {

                System.out.print("Nhập mã khách hàng: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Customer result_search = manager.search(id);

                if (result_search != null) {
                    CustomerManager.exportCustomer(result_search);

                } else {
                    System.out.print("Không tìm thấy khách hàng.");
                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhập mã khách hàng: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                manager.delete(id);

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.println("Chức năng đang được phát triển !!!");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 0) {
                BaseEntity.resetId();
                CustomerManager.saveFile();

                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }

        }
    }

}
