package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Transaction;
import repository.TransactionReponsitory;
import ui.TransactionUI;
import validation.InpuValidator;

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
        System.out.println("-------------------------");
        System.out.println("Ma giao dich            : " + transaction.getId());
        System.out.println("Ten thu ngan            : " + transaction.getEmployee().getName());
        System.out.println("Ten khach hang          : " + transaction.getCustomer().getName());
        System.out.println("Tong so tien            : " + transaction.getTotalAmount());
        System.out.println(
                "Ngay giao dich          : " + InpuValidator.formatLocalDate(transaction.getTransactionDate()));
        System.out.println("Phuong thuc thanh toan  : " + transaction.getPaymentMethod());
    }

    public static void exportAllTransaction(List<Transaction> transactions) {
        if (!transactions.isEmpty()) {
            System.out.println("===================================");
            System.out.println("         LICH SU GIAO DICH         ");
            System.out.println("===================================");
            System.out.println(
                    "-------+-------------------+-------------------+-----------------+-----------------+-----------------------------");
            System.out.println(
                    "|  Id  |     Thu ngan      |     Khach hang    |    Tong tien    | Ngay giao dich  |   Phuong thuc thanh toan   |");
            System.out.println(
                    "-------+-------------------+-------------------+-----------------+-----------------+-----------------------------");
            for (Transaction transaction : transactions) {

                System.out.println(
                        String.format("| %4s | %17s | %17s | %15s | %15s | %26s |",
                                transaction.getId(),
                                transaction.getEmployee().getName(),
                                transaction.getCustomer().getName(),
                                transaction.getTotalAmount(),
                                InpuValidator.formatLocalDate(transaction.getTransactionDate()),
                                transaction.getPaymentMethod()));
            }
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------");

            System.out.println();

        } else {
            System.out.println("Khong co du lieu nao!");
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
                // transaction.setPaymentMethod(updated_transaction.getPaymentMethod());
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
                System.out.println("Da xoa giao dich thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay giao dich co ma: " + id);
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
