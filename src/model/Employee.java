package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Employee extends BaseEntity {

    private String name;
    private String gender;
    private int age;
    private String phone;
    private String position;
    private double salary;
    private static final Map<Integer, Double> luongNhanVien = new HashMap<>();

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

    public Employee(int id, String name, String gender, int age, String phone, String position, double salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getsalary() {
        return this.salary;
    }

    public void setsalary(double salary) {
        this.salary = salary;
        setLuong(getId(), salary);
    }

    public double tinhLuong() {
        return luongNhanVien.getOrDefault(getId(), 1.0);
    }

    public static void setLuong(int id, double luong) {
        luongNhanVien.put(id, luong);
    }

    public static double getLuong(int id) {
        return luongNhanVien.getOrDefault(id, 1.0);
    }

}
