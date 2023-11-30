package model;

import java.util.Scanner;

public class NVBH extends Employee {
    private int soGio;

    public NVBH() {

    }

    public NVBH(String name, String gender, int age, String phone, String position, int soGio) {
        super(name, gender, age, phone, position);
        this.soGio = soGio;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap so gio: ");
        soGio = sc.nextInt();
    }

    public void xuat() {
        super.exportEmployee(null);
        System.out.println("So gio lam: " + this.soGio);

    }

    @Override
    public double tinhLuong() {
        return this.soGio * 20000;
    }
}
