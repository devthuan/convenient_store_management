package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Employee;
import model.InterfaceCRUD;
import repository.EmployeeRepository;
import ui.EmployeeUI;

public class EmployeeManager implements InterfaceCRUD {
    static List<Employee> employees = new ArrayList<>();

    public static void startEmployeeManager(Scanner scanner) {
        EmployeeUI.handleEmployee(scanner, employees);
    }

    @Override
    public void create(Object entity) {
        if (entity instanceof Employee) {
            Employee employee = (Employee) entity;
            employees.add(employee);
            String file_path = "convenient_store_management/src/data/employee_data.txt";

            EmployeeRepository.writeFile(employee, file_path);
        }
    }

    @Override
    public Object read(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void update(Object entity) {
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
