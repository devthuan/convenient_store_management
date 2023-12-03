package ui;

import java.util.List;
import java.util.Scanner;

import model.BaseEntity;
import model.Customer;
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
                while (!scanner.hasNextInt()) {
                    System.out.print("Vui lòng nhập số (1-NVBH hoặc 2-NVQL): ");
                    scanner.next(); // Đọc và bỏ qua dữ liệu không phải số nguyên
                }
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
                        if (age >= 1 && age <= 100) {
                            break;
                        } else {
                            System.out.print("Tuổi không hợp lệ. Vui lòng nhập lại : ");
                        }
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

                Employee new_employee;
                if (loaiNhanVien == 1) {
                    new_employee = new NVBH(name, gender, age, phone);
                    Employee.setLuong(new_employee.getId(), new_employee.tinhLuong());
                } else if (loaiNhanVien == 2) {
                    new_employee = new NVQL(name, gender, age, phone);
                    Employee.setLuong(new_employee.getId(), new_employee.tinhLuong());
                } else {
                    continue;
                }

                employees.add(new_employee);
                System.out.println("Đã tạo nhân viên thành công.");

            } else if (option == 2) {

                if (employees.isEmpty()) {
                    System.out.println("Không có nhân viên nào.");
                } else {
                    EmployeeManager.exportAllEmployee(employees);

                }

            } else if (option == 3) {

                System.out.print("Nhập mã nhân viên: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Employee result_search = manager.search(id);

                if (result_search != null) {
                    EmployeeManager.exportEmployee(result_search);

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
                System.out.print("Nhập mã nhân viên cần cập nhật : ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Employee result_search = manager.search(id);

                if (result_search != null) {
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
                            if (age >= 1 && age <= 100) {
                                break;
                            } else {
                                System.out.print("Tuổi không hợp lệ. Vui lòng nhập lại : ");
                            }
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
                    Employee updatedEmployee = new Employee(name, gender, age, phone);
                    manager.update(id, updatedEmployee);
                    System.out.println("Cập nhật thông tin nhân viên thành công");
                } else {
                    System.out.println("Không tìm thấy nhân viên có mã: " + id);
                }
            } else if (option == 0) {
                BaseEntity.resetId();
                for (Employee employee : employees) {
                    Employee.setLuong(employee.getId(), employee.tinhLuong());
                }
                EmployeeManager.saveFile();

                break;
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                continue;
            }

        }
    }

}