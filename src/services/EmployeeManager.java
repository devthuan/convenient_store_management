package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.InterfaceCRUD;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import ui.EmployeeUI;

public class EmployeeManager implements InterfaceCRUD<Employee> {
    static List<Employee> employees = new ArrayList<>();
    static String file_path = "src/data/employee_data.txt";

    public static void startEmployeeManager(Scanner scanner) {
        EmployeeUI.handleEmployee(scanner, employees);
    }

    static void readFile() {
        List<Employee> data_employees = EmployeeRepository.readFileEmployee(file_path);

        employees.clear();
        for (Employee employee : data_employees) {
            employees.add(employee);
        }
    }

    public static void saveFile() {
        EmployeeRepository.writeEmployeeToFile(employees, file_path);
    }

    @Override
    public void create(Employee employee) {
        // employees.add(employee);
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
    public void update(int id, Employee updateEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == id) {
                employee.setName(updateEmployee.getName());
                employee.setGender(updateEmployee.getGender());
                employee.setAge(updateEmployee.getAge());
                employee.setPhone(updateEmployee.getPhone());
                employee.setPosition(updateEmployee.getPosition());
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        Employee deleteEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                deleteEmployee = employee;
                break;
            }
        }

        if (deleteEmployee != null) {
            employees.remove(deleteEmployee);
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
