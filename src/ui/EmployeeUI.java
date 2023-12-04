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
            System.out.print("Nhap tuy chon: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.println("Chon loai nhan vien (1 - NVBH, 2 - NVQL) :");
                System.out.println("+-------------------------+");
                System.out.println("|         1. NVBH         |");
                System.out.println("|         2. NVQL         |");
                System.out.println("+-------------------------+");
                System.out.print("Nhap lua chon cua ban: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Vui lòng nhập số (1-NVBH hoặc 2-NVQL): ");
                    scanner.next();
                }
                int loaiNhanVien;
                do {
                    loaiNhanVien = scanner.nextInt();
                    if (loaiNhanVien != 1 && loaiNhanVien != 2) {
                        System.out.print("Vui long nhan lai (1-NVBH hoac 2-NVQL):");
                    }
                } while (loaiNhanVien != 1 && loaiNhanVien != 2);
                scanner.nextLine();

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
                System.out.print("Nhap chuc vu: ");
                String position;
                if (loaiNhanVien == 1) {
                    do {
                        position = scanner.nextLine();
                        if (!position.equalsIgnoreCase("NVBH")) {
                            System.out.print("Vui lòng nhập chính xác chức vụ (NVBH): ");
                        }
                    } while (!position.equalsIgnoreCase("NVBH"));
                } else if (loaiNhanVien == 2) {
                    do {
                        position = scanner.nextLine();
                        if (!position.equalsIgnoreCase("NVQL")) {
                            System.out.print("Vui lòng nhập chính xác chức vụ (NVQL): ");
                        }
                    } while (!position.equalsIgnoreCase("NVQL"));
                } else {
                    continue;
                }
                Employee new_employee;
                if (loaiNhanVien == 1) {
                    new_employee = new NVBH(name, gender, age, phone, position);
                    Employee.setLuong(new_employee.getId(), new_employee.tinhLuong());
                } else if (loaiNhanVien == 2) {
                    new_employee = new NVQL(name, gender, age, phone, position);
                    Employee.setLuong(new_employee.getId(), new_employee.tinhLuong());
                } else {
                    continue;
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
                    System.out.print("Nhap chuc vu: ");
                    String position;
                    do {
                        position = scanner.nextLine();
                        if (!position.equalsIgnoreCase("NVBH") && !position.equalsIgnoreCase("NVQL")) {
                            System.out.print("Vui lòng nhập chính xác chức vụ (NVBH / NVQL): ");
                        }
                    } while (!position.equalsIgnoreCase("NVBH") && !position.equalsIgnoreCase("NVQL"));
                    if (!position.equalsIgnoreCase(result_search.getPosition())) {
                        result_search.setPosition(position);
                        if (position.equalsIgnoreCase("NVBH")) {
                            Employee.setLuong(result_search.getId(), 20000);
                        } else if (position.equalsIgnoreCase("NVQL")) {
                            Employee.setLuong(result_search.getId(), 30000);
                        }
                    }
                    Employee updatedEmployee = new Employee(name, gender, age, phone, position);
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