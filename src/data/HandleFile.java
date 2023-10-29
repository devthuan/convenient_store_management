package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import object.Invoice;
import object.Product;
import functional.InvoiceManagement;

public class HandleFile {

    // đọc file theo format ["id", "ten khach hang" | "id san pham", "ten san pham",
    // "gia" : "id san pham", "ten san pham", "gia"]
    // ví dụ : 1, thuan | 1, number one, 10000.0 : 2, coffee, 23000.0
    public static List<Invoice> readInvoicesFromFile(String filePath) {
        List<Invoice> invoices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                String[] invoice_info = parts[0].split(", ");
                int invoiceId = Integer.parseInt(invoice_info[0]);
                String customerName = invoice_info[1];
                List<Product> list_product = new ArrayList<>();

                String[] products = parts[1].split(":");
                for (String product : products) {
                    String[] productInfo = product.split(", ");
                    int productId = Integer.parseInt(productInfo[0].trim());
                    String productName = productInfo[1];
                    double productPrice = Double.parseDouble(productInfo[2]);
                    list_product.add(new Product(productId, productName, productPrice));
                }

                // Tạo mới đối tượng Invoice ở đây
                Invoice new_invoice = Invoice.createInvoice(invoiceId, customerName, list_product);

                // Thêm hóa đơn vào danh sách
                invoices.add(new_invoice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return invoices;
    }

    // ghi file theo format ["id", "ten khach hang" | "id san pham", "ten san pham",
    // "gia" : "id san pham", "ten san pham", "gia"]
    // ví dụ : 1, thuan | 1, number one, 10000.0 : 2, coffee, 23000.0
    public static void writeInvoicesToFile(Invoice invoice, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

            writer.write(invoice.getInvoiceId() + ", " + invoice.getCustomerName() + " | ");

            List<Product> products = invoice.getProducts();
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                writer.write(product.getProductId() + ", " + product.getProductName() + ", "
                        + product.getProductPrice());
                if (i < products.size() - 1) {
                    writer.write(" : ");
                }
            }
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
