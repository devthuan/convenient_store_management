package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import model.NVBH;
import model.NVQL;

public class EmployeeRepository {
    public static List<Employee> readFileEmployee(String file_path) {
        List<Employee> EmployeeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String gender = data[2];
                    int age = Integer.parseInt(data[3]);
                    String phone = data[4];
                    double salary = Double.parseDouble(data[5]);
                    Employee employee;
                    if (salary >= 30000) {

                        employee = new NVQL(name, gender, age, phone, salary);
                    } else {
                        employee = new NVBH(name, gender, age, phone, salary);

                    }

                    EmployeeList.add(employee);

                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EmployeeList;
    }

    public static void writeFileEmployee(Employee employee, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            writer.write(employee.getId() + "," +
                    employee.getName() + "," +
                    employee.getGender() + "," +
                    employee.getAge() + "," +
                    employee.getPhone());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeEmployeesToFile(List<Employee> employees, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (Employee employee : employees) {
                double salary = Employee.getLuong(employee.getId());
                writer.write(employee.getId() + "," +
                        employee.getName() + "," +
                        employee.getGender() + "," +
                        employee.getAge() + "," +
                        employee.getPhone() + "," +
                        salary);
                writer.newLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}