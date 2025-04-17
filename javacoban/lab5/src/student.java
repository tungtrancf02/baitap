import java.util.Scanner;
import java.lang.*;
public class student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so hoc sinh");
        int n = sc.nextInt();
        double[] so = new double[n];// tao mang
        for (int i = 0; i < n; i++) {


            do {

                System.out.println("diem cua học sinh" + (i +1  ) + ":");
                so[i] = sc.nextDouble();

                if (so[i] > 10 || so[i] < 0)// neu nhap sai diem

                    System.out.println("mời nhập lại điểm");


            }

            while (so[i] > 10 || so[i] < 0); //kiem tra xem co nhap sai diem ko


        }
        for (int i = 0; i < n; i++) {
            System.out.println("Học sinh " + (i+1) + ": " + so[i]);
        }

            double max = so[0];//tim diem lon nhat
            for (int i = 0; i < n; i++) {
                if (max < so[i])
                    max = so[i];

            }
            System.out.println("diem cao nhat cua " + (n) + " học sinh la : " + max);

            int dem = 0;
            for ( int i= 1; i < n; i++) {
                if (so[i] <= 5)
                    dem++;



            }
            System.out.println("so hoc sinh duoi trung binh la: " + dem);
            for (int i = 0; i < n; i++) {

                if (so[i] <= 5)
                    so[i]++;
                System.out.println("diem cua hoc sinh sau khi tangw"+so[i] );
            }

        }

    }


