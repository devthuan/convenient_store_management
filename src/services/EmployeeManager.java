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
    static String file_path = "convenient_store_management/src/data/emplyee_data.txt";

    public static void startEmployeeManager(Scanner scanner) {
        EmployeeUI.handleEmployee(scanner, employees);
    }

    public static void saveFile() {
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
    public void update(int id, Employee entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");

    }

    @Override
    public void delete(int id) {
        Employee employeeToRemove = (Employee) read(id);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Đã xóa nhân viên có mã " + id);
        } else {
            System.out.println("Không tìm thấy nhân viên có mã " + id);
        }
    }

    @Override
    public Employee search(int id) {
        return (Employee) read(id);
    }

}
