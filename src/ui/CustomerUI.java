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
            Menu.menuCustomer();
            System.out.print("Nhap tuy chon: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhap ho vao ten: ");
            if (option == 1) {
                String name;
                while (true) {
                    name = scanner.nextLine();
                    if (name.matches(".*\\d+.*")) {
                        System.out.println("Vui long nhap lai");
                    } else {
                        break;
                    }
                }

                System.out.print("Nhap dia chi: ");
                String address = scanner.nextLine();

                String phone;
                System.out.println("Nhap so dien thoai : ");
                while (true) {
                    phone = scanner.nextLine();
                    if (!checkPhone(phone)) {
                        System.out.println("So dien thoai khong hop le. Vui long chi su dung so");
                    } else if (phone.length() != 10 && checkPhone(phone)) {
                        System.out.println("So dien thoai khong hop le. Vui long nhap chinh xac 10 so");
                    } else {
                        break;
                    }
                }

                Customer new_customer = new Customer(name, address, phone);
                manager.create(new_customer);

                System.out.println("Da tao khach hang thanh cong.");

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 2) {

                if (customers.isEmpty()) {
                    System.out.println("Khong co khach hang nao.");
                } else {
                    CustomerManager.exportAllEmployee(customers);

                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 3) {

                System.out.print("Nhap ma khach hang: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Customer result_search = manager.search(id);

                if (result_search != null) {
                    CustomerManager.exportCustomer(result_search);

                } else {
                    System.out.print("Không tìm thấy khách hàng.");
                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhap ma khach hang: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                manager.delete(id);

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.print("Nhap ma khach hang can cap nhat : ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Customer result_search = manager.search(id);

                if (result_search != null) {
                    System.out.print("Nhap ten khach hang: ");
                    String name;
                    while (true) {
                        name = scanner.nextLine();
                        if (name.matches(".*\\d+.*")) {
                            System.out.print("Vui long nhap lai: ");
                        } else {
                            break;
                        }
                    }

                    System.out.println("Nhap dia chi: ");
                    String address = scanner.nextLine();

                    System.out.print("Nhap so dien thoai: ");
                    String phone;
                    while (true) {
                        phone = scanner.nextLine();
                        if (!checkPhone(phone)) {
                            System.out.println("So dien thoai khong hop le. Vui long chi su dung so");
                        } else if (phone.length() != 10 && checkPhone(phone)) {
                            System.out.println("So dien thoai khong hop le. Vui long nhap chinh xac 10 so");
                        } else {
                            break;
                        }
                    }
                    Customer updatedCustomer = new Customer(name, address, phone);
                    manager.update(id, updatedCustomer);
                    System.out.println("Cap nhat thong tin khach hang thanh cong");
                } else {
                    System.out.println("Khong tim thay khach hang co ma: " + id);
                }
            } else if (option == 0) {
                BaseEntity.resetId();
                CustomerManager.saveFile();

                break;
            } else {
                System.out.println("Tuy chon khong hop le. Vui long nhap lai");
                continue;

            }

        }
    }

}
