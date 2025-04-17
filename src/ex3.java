
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner mang = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong mảng: ");// Nhập so phan tu mảng
        int n = mang.nextInt();

        int[] giatri = new int[n];


        System.out.println("nhap gia tri cua mang:");//nhap gia tri
        for (int i = 0; i < n; i++) {
            giatri[i] = mang.nextInt();
        }
        int min = giatri[0];//tim gai tri nho nhat
        for (int i = 1; i < n; i++) {
            if (giatri[i] < min) {
                min = giatri[i];
                System.out.println("so nho nhat trong mang la:"+giatri[i]);
            }

        }

        }
}