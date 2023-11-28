package model;

import java.util.List;
import java.util.Scanner;

public class Employee extends BaseEntity {

    private String name;
    private String gender;
    private int age;
    private String phone;
    private String position;
    private double salary;

    public Employee() {

    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String gender, int age, String phone, String position) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.position = position;
    }

    public Employee(int id, String name, String gender, int age, String phone, String position) {
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

    public double tinhLuong() {
        return salary;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        this.name = sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        this.gender = sc.nextLine();
        System.out.println("Nhap tuoi: ");
        this.age = sc.nextInt();
        System.out.println("Nhap so dien thoai: ");
        this.phone = sc.nextLine();
        System.out.println("Nhap chuc vu: ");
        this.position = sc.nextLine();

    }

    public static void exportEmployee(Employee employee) {
        System.out.println("------------------------------------------------");
        System.out.println("Mã nhân viên : " + employee.getId());
        System.out.println("Họ và tên    : " + employee.getName());
        System.out.println("Giới tính    : " + employee.getGender());
        System.out.println("Tuổi         : " + employee.getAge());
        System.out.println("Số điện thoại: " + employee.getPhone());
        System.out.println("Chức vụ      : " + employee.getPosition());
        System.out.println("Lương        : " + employee.tinhLuong());
        System.out.println("------------------------------------------------");
    }

    public static void exportAllEmployee(List<Employee> employees) {
        if (employees != null) {
            System.out.println("===================================");
            System.out.println("         DANH SÁCH NHÂN VIÊN       ");
            System.out.println("===================================");
            System.out.println(
                    "-------+---------------------+-------------+--------+------------------+-------------+-----------------");
            System.out.println(
                    "|  ID  |     Họ và tên       |  Giới tính  |  Tuổi  |  Số điện thoại   |  Chức vụ    +  Tiền lương     ");
            System.out.println(
                    "-------+---------------------+-------------+--------+------------------+-------------+-----------------");
            for (Employee employee : employees) {

                System.out.printf(
                        String.format("| %4s | %19s | %11s | %6s | %15s  | %10s  |",
                                employee.getId(),
                                employee.getName(),
                                employee.getGender(),
                                employee.getAge(),
                                employee.getPhone(),
                                employee.getPosition()));
                if (employee instanceof NVBH) {
                    NVBH nvbh = (NVBH) employee;
                    System.out.println(String.format(" %10s ", nvbh.tinhLuong()));
                } else if (employee instanceof NVQL) {
                    NVQL nvql = (NVQL) employee;
                    System.out.println(String.format(" %10s ", nvql.tinhLuong()));
                } else {
                    System.out.println("                |");
                }
            }
            System.out.println(
                    "------------------------------------------------------------------------------------------------------");
            System.out.println();

        } else {
            System.out.println("Không có dữ liệu nào!");
        }
    }

}
