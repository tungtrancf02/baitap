import java.util.Scanner;

public class aray1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng số cần nhập
        System.out.print("Nhập số lượng số: ");
        int n = scanner.nextInt();

        // Tạo mảng để lưu trữ các số
        int[] numbers = new int[n];

        // Nhập các số
        System.out.println("Nhập " + n + " số:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();

        }
    }
}