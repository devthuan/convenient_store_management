package model;

import java.util.List;

public class Employee extends BaseEntity {

    private String name;
    private String gender;
    private int age;
    private String phone;
    private String position;

    public Employee() {

    }

    public Employee(String name, String gender, int age, String phone, String position) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public static void exportEmployee(Employee employee) {
        System.out.println("------------------------------------------------");
        System.out.println("Mã nhân viên : " + employee.getId());
        System.out.println("Họ và tên    : " + employee.getName());
        System.out.println("Giới tính    : " + employee.getGender());
        System.out.println("Tuổi         : " + employee.getAge());
        System.out.println("Số điện thoại: " + employee.getPhone());
        System.out.println("Chức vụ      : " + employee.getPosition());
        System.out.println("------------------------------------------------");
    }

    public static void exportAllEmployee(List<Employee> employees) {
        if (employees != null) {
            System.out.println("===================================");
            System.out.println("         DANH SÁCH NHÂN VIÊN       ");
            System.out.println("===================================");
            System.out.println("-------+---------------------+-------------+--------+-----------------+-------------");
            System.out.println("|  ID  |     Họ và tên       |  Giới tính  |  Tuổi  |  Số điện thoại  |  Chức vụ   |");
            System.out.println("-------+---------------------+-------------+--------+-----------------+-------------");
            for (Employee employee : employees) {

                System.out.println(
                        String.format("| %4s | %19s | %11s | %6s | %15s | %10s |",
                                employee.getId(),
                                employee.getName(),
                                employee.getGender(),
                                employee.getAge(),
                                employee.getPhone(),
                                employee.getPosition()));
            }
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println();

        } else {
            System.out.println("Không có dữ liệu nào!");
        }
    }

}
