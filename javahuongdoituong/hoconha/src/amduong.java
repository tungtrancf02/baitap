import java.util.Scanner;

public class amduong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao 1 so: ");
        int a ;
        do {
a= sc.nextInt();
                if (a > 0)
                    System.out.println(a + "la mot so duong");

                else if (a < 0)
                    System.out.println(a + "la mot so am");
                else System.out.println("loi");
            }
            while (a != 0) ;
            sc.close();

    }}


