package ui;

import java.util.List;
import java.util.Scanner;

import model.Employee;
import repository.EmployeeRepository;
import services.CustomerManager;
import services.EmployeeManager;

public class EmployeeUI {
    public static void handleEmployee(Scanner scanner, List<Employee> employees) {
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            Menu.menuEmployee();
            System.out.print("Nhập tuỳ chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Nhân tên nhân viên: ");
                String name = scanner.nextLine();

                System.out.print("Nhập giới tính: ");
                String gender = scanner.nextLine();

                System.out.print("Nhập tuổi: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nhập số điện thoại: ");
                String phone = scanner.nextLine();

                System.out.print("Nhập chức vụ: ");
                String position = scanner.nextLine();

                Employee new_employee = new Employee(name, gender, age, phone, position);
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
                System.out.println("Dữ liệu khách hàng đã được lưu vào tệp tin.");
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
