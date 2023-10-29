package ui;

public class Menu {

    public static void menuMain() {
        System.out.println("╔══════════════════════════╗");
        System.out.println("║       MEMU QUẢN LÝ       ║");
        System.out.println("║══════════════════════════║");
        System.out.println("║ 1. Quản lý khách hàng    ║");
        System.out.println("║ 2. Quản lý sản phẩm      ║");
        System.out.println("║ 3. Quản lý hoá đơn       ║");
        System.out.println("║ 4. Quản lý kho           ║");
        System.out.println("║ 5. Quản lý nhân viên     ║");
        System.out.println("║ 0. Thoát                 ║");
        System.out.println("╚══════════════════════════╝");
    }

    public static void menuInvoice() {
        System.out.println("+-------------------------------+");
        System.out.println("|     Thao tác với đơn hàng     |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Tạo đơn hàng               |");
        System.out.println("| 2. Xuất đơn hàng              |");
        System.out.println("| 3. Tìm kiếm đơn hàng          |");
        System.out.println("| 4. Xoá đơn hàng               |");
        System.out.println("| 0. Thoát khỏi menu đơn hàng   |");
        System.out.println("+-------------------------------+");
    }

    public static void menuEmployee() {

        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|     Thao tác với nhân viên    |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Tạo nhân viên              |");
        System.out.println("| 2. Xuất tất cả nhân viên      |");
        System.out.println("| 3. Tìm kiếm nhân viên         |");
        System.out.println("| 4. Xoá nhân viên              |");
        System.out.println("| 5. Lưu thông tin vào file     |");
        System.out.println("| 0. Thoát khỏi menu nhân viên  |");
        System.out.println("+-------------------------------+");
        System.out.println("");
    }
}
