package model;

public class NVQL extends Employee {

    private static double bonus = 1000;
    private static double managerial_allowance = 2000;

    public NVQL() {

    }

    public NVQL(String name, String gender, int age, String phone, double salary) {
        super(name, gender, age, phone, salary);
    }

    @Override
    public double tinhLuong() {
        return 30000 + bonus + managerial_allowance;
    }
}
