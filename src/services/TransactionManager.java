package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Transaction;
import repository.TransactionReponsitory;
import ui.TransactionUI;

public class TransactionManager implements InterfaceCRUD<Transaction> {
    static List<Transaction> transactions = new ArrayList<>();
    static String file_path = "convenient_store_management/src/data/transaction_data.txt";

    public static void startTransactionManager(Scanner scanner) {
        TransactionUI.handleTransaction(scanner, transactions);
    }

    public static void saveFile() {
        TransactionReponsitory.writeTransactionToFile(transactions, file_path);
        transactions.clear();

    }

    public static void readFile() {
        List<Transaction> transactions_in_file = TransactionReponsitory.readFileTransaction(file_path);
        transactions.clear();
        if (transactions_in_file != null) {
            for (Transaction transaction : transactions_in_file) {
                transactions.add(transaction);
            }

        }
    }

    public static void exportTransaction(Transaction transaction) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Mã giao dịch                 : " + transaction.getTransactionId());
        System.out.println("Tên thu ngân                      : " + transaction.getEmployee());
        System.out.println("Tên khách hàng                    : " + transaction.getCustomer());
        System.out.println("Tổng số tiền                   : " + transaction.getTotalAmount());
        System.out.println("Ngày giao dịch              :" + transaction.getTransactionDate());
        System.out.println("Phương thức thanh toán       : " + transaction.getPaymentMethod());
        System.out.println("--------------------------------------------------------------");
    }

    public static void exportAllTransaction(List<Transaction> transactions) {
        if (transactions != null) {
            System.out.println("===================================");
            System.out.println("         LỊCH SỬ GIAO DỊCH         ");
            System.out.println("===================================");
            System.out.println(
                    "-------+------------------+--------------------+-------------------+--------------------------+-------------------------------------");
            System.out.println(
                    "|  ID  |     THU NGÂN     |     KHÁCH HÀNG     |     TỔNG TIỀN     |      NGÀY GIAO DỊCH      |       PHƯƠNG THỨC THANH TOÁN       |");
            System.out.println(
                    "-------+------------------+--------------------+-------------------+--------------------------+-------------------------------------");
            for (Transaction transaction : transactions) {

                System.out.println(
                        String.format("| %4s | %19s | %11s | %6s | %15s | %10s |",
                                transaction.getTransactionId(),
                                transaction.getEmployee(),
                                transaction.getCustomer(),
                                transaction.getTotalAmount(),
                                transaction.getTransactionDate(),
                                transaction.getPaymentMethod()));
            }
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();

        } else {
            System.out.println("Không có dữ liệu nào!");
        }
    }

    @Override
    public void create(Transaction transaction) {

        transactions.add(transaction);
    }

    @Override
    public Transaction read(int id) {
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }

        }
        return null;

    }

    @Override
    public void update(int id, Transaction updated_transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.getId() == id) {
                transaction.setTransactionId(updated_transaction.getTransactionId());
                transaction.setTransactionDate(updated_transaction.getTransactionDate());
                transaction.setTotalAmount(updated_transaction.getTotalAmount());
                transaction.setPaymentMethod(updated_transaction.getPaymentMethod());
                transaction.setCustomer(updated_transaction.getCustomer());
                transaction.setEmployee(updated_transaction.getEmployee());
                // Cập nhật thông tin sản phẩm dựa trên ID
                return;
            }
        }

    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId() == id) {
                transactions.remove(i);
                System.out.println("Đã xóa giao dịch thành công!");

            }
        }
        System.out.println("Không tìm thấy giao dịch có mã: " + id);
    }

    @Override
    public Transaction search(int id) {
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

}
