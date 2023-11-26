package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Employee;

import services.EmployeeManager;

public class EmployeeUI {
    public static boolean checkPhone(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void handleEmployee(Scanner scanner, List<Employee> employees) {
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            Menu.menuEmployee();
            System.out.print("Nhập tuỳ chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Nhân tên nhân viên: ");
                String name;
                while (true) {
                    name = scanner.nextLine();
                    if (name.matches(".*\\d+.*")) {
                        System.out.println("Vui lòng nhập lại: ");
                    } else {
                        break;
                    }
                }

                System.out.print("Nhập giới tính: ");
                String gender;
                do {
                    gender = scanner.nextLine();

                    if (!gender.equals("Nam") && !gender.equals("Nu") && !gender.equals("Khac")) {
                        System.out.println("Vui lòng nhập lại: ");
                    }
                } while (!gender.equals("Nam") && !gender.equals("Nu") && !gender.equals("Khac"));

                System.out.print("Nhập tuổi: ");
                int age;
                while (true) {
                    if (scanner.hasNextInt()) {
                        age = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Tuổi không hợp lệ. Vui lòng nhập lại");
                        scanner.nextLine();
                    }
                }

                System.out.print("Nhập số điện thoại: ");
                String phone;
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

                System.out.print("Nhập chức vụ: ");
                String position = scanner.nextLine();

<<<<<<< HEAD
                System.out.println("Nhap so gio lam: ");
                int soGioLam;
                soGioLam = scanner.nextInt();
                Employee new_employee = new Employee(name, gender, age, phone, position, soGioLam);
                employees.add(new_employee);
=======
                Employee new_employee = new Employee(name, gender, age, phone, position);
                manager.create(new_employee);
>>>>>>> 46b719c51e4fa56e2c2dce3a815d5ddcfcaa7539

                System.out.println("Đã tạo nhân viên thành công.");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 2) {

                if (employees.isEmpty()) {
                    System.out.println("Không có nhân viên nào.");
                } else {
                    Employee.exportAllEmployee(employees);

                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 3) {

                System.out.print("Nhập mã nhân viên: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Employee result_search = manager.search(id);

                if (result_search != null) {
                    Employee.exportEmployee(result_search);

                } else {
                    System.out.print("Không tìm thấy nhân viên.");
                }

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhập mã nhân viên: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                manager.delete(id);

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 5) {
                EmployeeManager.saveFile();

                System.out.println("Chức năng đang được phát triển");

                System.out.print("Ấn Enter để tiếp tục....");
                scanner.nextLine();
            } else if (option == 0) {
                BaseEntity.resetId();
                EmployeeManager.saveFile();
                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }

        }
    }

}
