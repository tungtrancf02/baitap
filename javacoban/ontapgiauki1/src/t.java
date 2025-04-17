import java.util.ArrayList;
import java.util.Scanner;

// Lớp SanPham đại diện cho một sản phẩm trong siêu thị
class SanPham {
    private String tenSanPham;
    private int soLuongConLai;

    public SanPham(String tenSanPham, int soLuongConLai) {
        this.tenSanPham = tenSanPham;
        this.soLuongConLai = soLuongConLai;
    }

    @Override
    public String toString() {
        return "Tên sản phẩm: " + tenSanPham + ", Số lượng còn lại: " + soLuongConLai;
    }
}

public class t {
    public static void main(String[] args) {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Nhập danh sách sản phẩm
        System.out.print("Nhập số lượng sản phẩm muốn thêm: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
            System.out.print("Tên sản phẩm: ");
            String ten = scanner.nextLine();
            System.out.print("Số lượng còn lại: ");
            int soLuongConLai = Integer.parseInt(scanner.nextLine());

            // Thêm sản phẩm vào danh sách
            danhSachSanPham.add(new SanPham(ten, soLuongConLai));
        }

        // Xuất danh sách sản phẩm
        System.out.println("\nDanh sách sản phẩm:");
        for (SanPham sp : danhSachSanPham) {
            System.out.println(sp);
        }

        scanner.close();
    }
}
