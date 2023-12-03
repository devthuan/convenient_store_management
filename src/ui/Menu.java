package ui;

public class Menu {

    public static void menuMain() {
        System.out.println("╔══════════════════════════╗");
        System.out.println("║       MEMU QUẢN LÝ       ║");
        System.out.println("║══════════════════════════║");
        System.out.println("║ 1. Quản lý sản phẩm      ║");
        System.out.println("║ 2. Quản lý khách hàng    ║");
        System.out.println("║ 3. Quản lý đơn hàng      ║");
        System.out.println("║ 4. Quản lý nhân viên     ║");
        System.out.println("║ 5. Quản lý kho           ║");
        System.out.println("║ 6. Quản lý giao dịch     ║");
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
        System.out.println("| 5. Sửa thông tin nhân viên    |");
        System.out.println("| 0. Lưu thông tin và thoát     |");
        System.out.println("+-------------------------------+");
        System.out.println("");
    }

    public static void menuProduct() {

        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|     Thao tác với sản phẩm     |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Tạo sản phẩm               |");
        System.out.println("| 2. Xuất tất cả sản phẩm       |");
        System.out.println("| 3. Tìm kiếm sản phẩm          |");
        System.out.println("| 4. Xoá sản phẩm               |");
        System.out.println("| 5. Chỉnh sửa sản phẩm         |");
        System.out.println("| 0. Lưu thông tin và thoát     |");
        System.out.println("+-------------------------------+");
        System.out.println("");
    }

    public static void menuOrder() {

        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|     Thao tác với đơn hàng     |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Tạo đơn hàng               |");
        System.out.println("| 2. Xuất tất cả đơn hàng       |");
        System.out.println("| 3. Tìm kiếm đơn hàng          |");
        System.out.println("| 4. Xoá đơn hàng               |");
        System.out.println("| 5. Chỉnh sửa đơn hàng         |");
        System.out.println("| 0. Lưu thông tin và thoát     |");
        System.out.println("+-------------------------------+");
        System.out.println("");
    }

    public static void menuCustomer() {

        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|     Thao tác với khách hàng   |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Tạo khách hàng             |");
        System.out.println("| 2. Xuất tất cả khách hàng     |");
        System.out.println("| 3. Tìm kiếm khách hàng        |");
        System.out.println("| 4. Xoá khách hàng             |");
        System.out.println("| 5. Chỉnh sửa khách hàng       |");
        System.out.println("| 0. Lưu thông tin và thoát     |");
        System.out.println("+-------------------------------+");
        System.out.println("");
    }

    public static void menuTransaction() {

        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|     Thao tác với giao dịch    |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Tạo giao dịch              |");
        System.out.println("| 2. Xuất tất cả giao dịch      |");
        System.out.println("| 3. Tìm kiếm giao dịch         |");
        System.out.println("| 0. Thoát và lưu thông tin     |");
        System.out.println("+-------------------------------+");
        System.out.println("");
    }

    public static void menuInventory() {

        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|     Thao tác với kho hàng     |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Thêm sản phẩm vào kho      |");
        System.out.println("| 2. Kiểm kho                   |");
        System.out.println("| 3. Tìm sản phẩm trong kho     |");
        System.out.println("| 4. Cập số lượng và HSD kho    |");
        System.out.println("| 5. Xoá sản phẩm trong kho     |");
        System.out.println("| 0. Thoát và lưu thông tin     |");
        System.out.println("+-------------------------------+");
        System.out.println("");
    }

}
