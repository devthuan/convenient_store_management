package validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InpuValidator {
    public static int validateIntInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Vui lòng nhập số nguyên!");
                scanner.next();
            }
        }
    }

    public static double validateDoubleInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Vui lòng nhập số thập phân hoặc số nguyên!");
                scanner.next();
            }
        }
    }

    public static LocalDate validateLocalDateInput(Scanner scanner) {
        while (true) {
            try {
                String dateInput = validateStringInput(scanner);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(dateInput, formatter);
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại!");
            }
        }
    }

    public static String formatLocalDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public static String validateStringInput(Scanner scanner) {
        return scanner.nextLine().trim();
    }
}
