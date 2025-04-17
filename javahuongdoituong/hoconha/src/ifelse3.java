import java.util.Scanner;

public class ifelse3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap nam cua b");
        int nam = sc.nextInt();

        if (nam %4==0&& nam %100!=0  || (nam%400==0)){

            System.out.println("day la nam nhuan");

        }
        else
            System.out.println("khong phai la nam nhuan");
    }
}
