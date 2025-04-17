import java.util.Scanner;

public class tinhtonng {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n;

        int tong=0;
        for(int i=1;i<=5;i++){

            n=sc.nextInt();

            tong+=n;


        }
        System.out.println(tong);
    }
}
