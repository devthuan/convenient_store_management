package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeRepository {

    public static List<Employee> readFileEmployee(String file_path) {
        List<Employee> EmployeeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String gender = data[2];
                    int age = Integer.parseInt(data[3]);
                    String phone = data[4];
                    String position = data[5];
                    Employee employee = new Employee(id, name, gender, age, phone, position);
                    EmployeeList.add(employee);

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
                    employee.getPhone() + "," +
                    employee.getPosition());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void writeEmployeesToFile(List<Employee> employees, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," +
                        employee.getName() + "," +
                        employee.getGender() + "," +
                        employee.getAge() + "," +
                        employee.getPhone() + "," +
                        employee.getPosition() + "," +
                        employee.tinhLuong());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}