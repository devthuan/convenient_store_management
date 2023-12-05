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
import validation.InpuValidator;

public class EmployeeUI {
    public static boolean checkPhone(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int promptForEmployeeType(Scanner scanner) {
        int employeeType;
        do {
            System.out.println("Chon loai nhan vien (1 - NVBH, 2 - NVQL):");
            System.out.println("+-------------------------+");
            System.out.println("|         1. NVBH         |");
            System.out.println("|         2. NVQL         |");
            System.out.println("+-------------------------+");
            System.out.print("Nhap lua chon cua ban: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Vui long nhap so (1-NVBH hoac 2-NVQL): ");
                scanner.next(); // Discard non-integer input
            }

            employeeType = scanner.nextInt();
            if (employeeType != 1 && employeeType != 2) {
                System.out.print("Vui long nhan lai (1-NVBH hoac 2-NVQL): ");
            }
        } while (employeeType != 1 && employeeType != 2);

        scanner.nextLine(); // Consume the newline character
        return employeeType;
    }

    private static String promptForValidName(Scanner scanner) {
        String name;
        do {
            System.out.print("Nhan ten nhan vien: ");
            name = scanner.nextLine();
            if (name.matches(".*\\d+.*")) {
                System.out.print("Vui long nhap lai : ");
            }
        } while (name.matches(".*\\d+.*"));
        return name;
    }

    public static void handleEmployee(Scanner scanner, List<Employee> employees) {
        EmployeeManager manager = new EmployeeManager();
        while (true) {
            Menu.menuEmployee();
            System.out.print("Nhap tuy chon: ");
            int option = InpuValidator.validateIntInput(scanner);
            scanner.nextLine();
            if (option == 1) {

                int loaiNhanVien = promptForEmployeeType(scanner);
                String name = promptForValidName(scanner);

                System.out.print("Nhap gioi tinh: ");
                String gender;
                do {
                    gender = scanner.nextLine();

                    if (!gender.equals("Nam") && !gender.equals("Nu") && !gender.equals("Khac")) {
                        System.out.print("Vui long nhap lai (Nam / Nu/ Khac): ");
                    }
                } while (!gender.equals("Nam") && !gender.equals("Nu") && !gender.equals("Khac"));

                System.out.print("Nhap tuoi: ");
                int age;
                while (true) {
                    if (scanner.hasNextInt()) {
                        age = scanner.nextInt();
                        scanner.nextLine();
                        if (age >= 1 && age <= 100) {
                            break;
                        } else {
                            System.out.print("Tuoi khong hop le. Vui long nhap lai  : ");
                        }
                    }
                }

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

                Employee new_employee;

                if (loaiNhanVien == 1) {
                    new_employee = new NVBH(name, gender, age, phone, 20000);
                } else {
                    new_employee = new NVQL(name, gender, age, phone, 30000);
                }

                employees.add(new_employee);
                System.out.println("Da tao nhan vien thanh cong.");

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 2) {

                if (employees.isEmpty()) {
                    System.out.println("Không có nhân viên nào.");
                } else {
                    EmployeeManager.exportAllEmployee(employees);

                }

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 3) {

                System.out.print("Nhap ma nhan vien: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Employee result_search = manager.search(id);

                if (result_search != null) {
                    EmployeeManager.exportEmployee(result_search);

                } else {
                    System.out.print("Khong tim thay nhan vien.");
                }
                // continue;
                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 4) {
                System.out.print("Nhap ma nhan vien: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                manager.delete(id);

                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 5) {
                System.out.print("Nhap ma nhan vien can cap nhat : ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Employee result_search = manager.search(id);

                if (result_search != null) {
                    System.out.print("Nhan ten nhan vien: ");
                    String name;
                    while (true) {
                        name = scanner.nextLine();
                        if (name.matches(".*\\d+.*")) {
                            System.out.print("Vui long nhap lai : ");
                        } else {
                            break;
                        }
                    }

                    System.out.print("Nhap gioi tinh: ");
                    String gender;
                    do {
                        gender = scanner.nextLine();

                        if (!gender.equals("Nam") && !gender.equals("Nu") && !gender.equals("Khac")) {
                            System.out.print("Vui long nhap lai (Nam / Nu/ Khac): ");
                        }
                    } while (!gender.equals("Nam") && !gender.equals("Nu") && !gender.equals("Khac"));
                    System.out.print("Nhap tuoi: ");
                    int age;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            age = scanner.nextInt();
                            scanner.nextLine();
                            if (age >= 1 && age <= 100) {
                                break;
                            } else {
                                System.out.print("Tuoi khong hop le. Vui long nhap lai  : ");
                            }
                        }
                    }
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
                    Employee updatedEmployee;
                    if (result_search instanceof NVQL) {
                        updatedEmployee = new NVQL(name, gender, age, phone, 20000);

                    } else {

                        updatedEmployee = new NVBH(name, gender, age, phone, 30000);
                    }

                    manager.update(id, updatedEmployee);
                    System.out.println("Cap nhat thong tin thanh cong");
                } else {
                    System.out.println("Khong tim thay nhan vien co ma: " + id);
                }
                System.out.print("An Enter de tiep tuc....");
                scanner.nextLine();
            } else if (option == 0) {
                BaseEntity.resetId();
                for (Employee employee : employees) {
                    Employee.setLuong(employee.getId(), employee.tinhLuong());
                }
                EmployeeManager.saveFile();

                break;
            } else {
                System.out.println("Tuy chon khong hop le. Vui long nhap lai");
                continue;
            }

        }
    }

}