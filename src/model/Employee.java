package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract  class Employee extends BaseEntity {

    protected String name;
    private String gender;
    private int age;
    private String phone;
    private double salary;
    private static final Map<Integer, Double> luongNhanVien = new HashMap<>();

    public Employee() {

    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String gender, int age, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    public Employee( String name, String gender, int age, String phone, double salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
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

    public double getsalary() {
        return this.salary;
    }

    public void setsalary(double salary) {
        this.salary = salary;
        setLuong(getId(), salary);
    }

    public abstract double tinhLuong();

    public static void setLuong(int id, double luong) {
        luongNhanVien.put(id, luong);
    }

    public static double getLuong(int id) {
        return luongNhanVien.getOrDefault(id, 1.0);
    }

}
