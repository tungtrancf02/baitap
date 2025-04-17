import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner so = new Scanner(System.in);//khai báo nhập vào N sô nguyên
        System.out.println("Nhap vap sp nguyen n:");
        int N = so.nextInt();
        long tong = 0;// khai báo tong

        for (int i = 2; i <= N; i += 2) {// bắt đầu từ 2; được thực hện khi bé hơn N; sổ chản nên cng them 2
        tong += i;// tính tổng
        }
        System.out.println( "tong so cua "+N+"la "+tong);//in ra tổng




    }
}