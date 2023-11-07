package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.InterfaceCRUD;
import model.Transaction;

import ui.TransactionUI;

public class TransactionManager implements InterfaceCRUD<Transaction> {
        static List<Transaction> transactions = new ArrayList<>();
        static String file_path = "convenient_store_management/src/data/transaction_data.txt";

        public static void startTransactionManager(Scanner scanner) {
                TransactionUI.handleTransaction(scanner, transactions);
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
        public void create(Transaction entity) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'create'");
        }

        @Override
        public Transaction read(int id) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'read'");
        }

        @Override
        public void update(int id, Transaction entity) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'update'");
        }

        @Override
        public void delete(int id) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }

        @Override
        public Transaction search(int id) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'search'");
        }

}
