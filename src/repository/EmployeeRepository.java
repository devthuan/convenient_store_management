package repository;

import java.io.BufferedWriter;
import java.io.FileWriter;

import model.Employee;

public class EmployeeRepository {

    public static void writeFile(Employee employee, String file_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            writer.write(employee.getId() + "," +
                    employee.getName() + "," +
                    employee.getGender() + "," +
                    employee.getAge() + "," +
                    employee.getPhone() + "," +
                    employee.getPosition());
            writer.newLine();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
