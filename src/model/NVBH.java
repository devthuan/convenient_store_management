package model;

public class NVBH extends Employee {
    private static double bonus = 1000;

    public NVBH() {

    }

    public NVBH(String name) {
        this.name = name;
    }

    public NVBH(String name, String gender, int age, String phone, double salary) {
        super(name, gender, age, phone, salary);
    }

    @Override
    public double tinhLuong() {
        return 20000 + bonus;
    }
}
