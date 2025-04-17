import java.util.Scanner;
public class bai3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so n:  ");
        int n = sc.nextInt();
        int tong=0;
        for (int i = 0; i <= n; i++) {
            if (i % 2!=0)
                tong=tong+i;


        }
        System.out.println("tong la : "+ tong);


    }
}
