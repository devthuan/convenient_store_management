package ui;

import java.util.List;
import java.util.Scanner;

import model.Employee;
import model.NVBH;
import model.NVQL;
import repository.EmployeeRepository;
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
                System.out.println("Chọn loại nhân viên(1 - NVBH, 2 - NVQL) :");
                System.out.println("+-------------------------+");
                System.out.println("|         1. NVBH         |");
                System.out.println("|         2. NVQL         |");
                System.out.println("+-------------------------+");
                System.out.print("Nhập lựa chọn của bạn: ");
                int loaiNhanVien;
                do {
                    loaiNhanVien = scanner.nextInt();
                    if (loaiNhanVien != 1 && loaiNhanVien != 2) {
                        System.out.print("Vui lòng chọn lại (1-NVBH hoặc 2-NVQL):");
                    }
                } while (loaiNhanVien != 1 && loaiNhanVien != 2);
                scanner.nextLine();

                System.out.print("Nhân tên nhân viên: ");
                String name;
                while (true) {
                    name = scanner.nextLine();
                    if (name.matches(".*\\d+.*")) {
                        System.out.print("Vui lòng nhập lại: ");
                    } else {
                        break;
                    }
                }

                System.out.print("Nhập giới tính: ");
                String gender;
                do {
                    gender = scanner.nextLine();

                    if (!gender.equals("Nam") && !gender.equals("Nu") && !gender.equals("Khac")) {
                        System.out.print("Vui lòng nhập lại(Nam / Nu/ Khac): ");
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
                        System.out.print("Tuổi không hợp lệ. Vui lòng nhập lại : ");
                        scanner.nextLine();
                    }
                }

                System.out.print("Nhập số điện thoại: ");
                String phone;
                while (true) {
                    phone = scanner.nextLine();
                    if (!checkPhone(phone)) {
                        System.out.print("Số điện thoại không hợp lệ. Vui lòng chỉ sử dụng các chữ số : ");
                    } else if (phone.length() != 10 && checkPhone(phone)) {
                        System.out.print("Số điện thoại không hợp lệ. Vui lòng nhập chính xác 10 chữ số : ");
                    } else {
                        break;
                    }
                }

                System.out.print("Nhập chức vụ: ");
                String position = scanner.nextLine();

                Employee new_employee;
                if (loaiNhanVien == 1) {
                    System.out.print("Nhập số giờ làm của NVBH: ");
                    int soGioLam = scanner.nextInt();
                    scanner.nextLine();
                    new_employee = new NVBH(name, gender, age, phone, position, soGioLam);
                } else if (loaiNhanVien == 2) {
                    System.out.print("Nhập số giờ làm của NVQL: ");
                    int soGioLam = scanner.nextInt();
                    scanner.nextLine();
                    new_employee = new NVQL(name, gender, age, phone, position, soGioLam);
                } else {
                    continue;
                }

                employees.add(new_employee);
                System.out.println("Đã tạo nhân viên thành công.");

            } else if (option == 2) {

                if (employees.isEmpty()) {
                    System.out.println("Không có nhân viên nào.");
                } else {
                    Employee.exportAllEmployee(employees);

                }

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
                continue;
            } else if (option == 4) {
                System.out.print("Nhập mã nhân viên: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                manager.delete(id);

            } else if (option == 5) {
                EmployeeManager.saveFile();
                System.out.println("Thông tin nhân viên đã được lưu thành công");

            } else if (option == 0) {

                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;

            }

        }
    }

}
