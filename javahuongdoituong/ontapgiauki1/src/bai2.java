import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so cac chu so : ");
        int n = sc.nextInt();



        int max = 0;
        int min = n;
        for (int i = 0; i < n; i++) {

            System.out.println("so" + (i + 1) + "la");
            int m = sc.nextInt();



            if (m > max){
                max = m;}



            if (m < min){
                min = m;}

        }
        System.out.println("so lon nhat la: " + max);
        System.out.println("so nhỏ nhat la : " + min);
    }
}
