import java.util.ArrayList;
import java.util.Scanner;

public class tong {
    public static void main(String[] args) {
        // Tạo một ArrayList để lưu trữ các chuỗi
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng phần tử
        System.out.print("Nhập số lượng tên bạn muốn thêm: ");
        int numberOfNames = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng thừa sau khi nhập số

        // Nhập dữ liệu từ bàn phím và thêm vào ArrayList
        for (int i = 0; i < numberOfNames; i++) {
            System.out.print("Nhập tên thứ " + (i + 1) + ": ");
            String name = scanner.nextLine();
            names.add(name);
        }

        // Xuất dữ liệu từ ArrayList
        System.out.println("\nDanh sách tên bạn đã nhập:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
