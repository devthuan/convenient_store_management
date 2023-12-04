package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Employee;
import model.InterfaceCRUD;
import repository.EmployeeRepository;
import ui.EmployeeUI;

public class EmployeeManager implements InterfaceCRUD<Employee> {
    static List<Employee> employees = new ArrayList<>();
    static String file_path = "src/data/employee_data.txt";

    public static void startEmployeeManager(Scanner scanner) {
        EmployeeUI.handleEmployee(scanner, employees);
    }

    public static void exportEmployee(Employee employee) {
        System.out.println("------------------------------------------------");
        System.out.println("Ma nhan vien : " + employee.getId());
        System.out.println("Ho va ten    : " + employee.getName());
        System.out.println("Gioi tinh    : " + employee.getGender());
        System.out.println("Tuoi         : " + employee.getAge());
        System.out.println("So dien thoai: " + employee.getPhone());
        System.out.println("Chuc vu      : " + employee.getPosition());
        System.out.println("Tien Luong   : " + employee.tinhLuong());
        System.out.println("------------------------------------------------");
    }

    public static void exportAllEmployee(List<Employee> employees) {
        if (employees != null) {
            System.out.println("===================================");
            System.out.println("         DANH SÁCH NHÂN VIÊN       ");
            System.out.println("===================================");
            System.out.println(
                    "-------+---------------------+-------------+--------+------------------+--------------+--------------");
            System.out.println(
                    "|  ID  |     Ho va ten       |  Gioi tinh  |  Tuoi  |  So dien thoai   |     Chuc vu  |  Tien Luong |");
            System.out.println(
                    "-------+---------------------+-------------+--------+------------------+--------------|-------------");

            for (Employee employee : employees) {
                double salary = Employee.getLuong(employee.getId());
                System.out.println(
                        String.format("| %4s | %19s | %11s | %6s | %16s | %12s | %10s  |",
                                employee.getId(),
                                employee.getName(),
                                employee.getGender(),
                                employee.getAge(),
                                employee.getPhone(),
                                employee.getPosition(),
                                salary));

            }
            System.out
                    .println(
                            "--------------------------------------------------------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Khong co du lieu nao!");
        }
    }

    public static void saveFile() {
        for (Employee employee : employees) {
            Employee.setLuong(employee.getId(), employee.tinhLuong());
        }
        EmployeeRepository.writeEmployeesToFile(employees, file_path);
        employees.clear();
    }

    public static void readFile() {
        List<Employee> employees_in_file = EmployeeRepository.readFileEmployee(file_path);
        employees.clear();
        if (employees_in_file != null) {
            for (Employee employee : employees_in_file) {
                employees.add(employee);
            }

        }
    }

    @Override
    public void create(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee read(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Employee updated_employee) {
        Employee foundEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                foundEmployee = employee;
                break;
            }
        }
        if (foundEmployee != null) {
            foundEmployee.setName(updated_employee.getName());
            foundEmployee.setAge(updated_employee.getAge());
            foundEmployee.setGender(updated_employee.getGender());
            foundEmployee.setPhone(updated_employee.getPhone());
            foundEmployee.setPosition(updated_employee.getPosition());
        }
    }

    @Override
    public void delete(int id) {
        Employee employeeToRemove = (Employee) read(id);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Da xoa nhan vien co ma " + id);
        } else {
            System.out.println("Khong tim thay nhan vien co ma " + id);
        }
    }

    @Override
    public Employee search(int id) {
        return (Employee) read(id);
    }

}