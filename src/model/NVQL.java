package model;

public class NVQL extends Employee {
    public NVQL() {

    }

    public NVQL(String name, String gender, int age, String phone, String position) {
        super(name, gender, age, phone, position);
    }

    @Override
    public double tinhLuong() {
        return 30000;
    }
}
