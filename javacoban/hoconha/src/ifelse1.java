import java.util.Scanner;

public class ifelse1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println( "moi nhap vao tong caur hai so");
        double tong = sc.nextDouble();
        System.out.println("moi nhap vao hiue cua hai so");
        double hiue = sc.nextDouble();


        double x= (tong+hiue)/2;
        double y=(tong-x);

        System.out.println("gia tri x can tim la: "+x);
        System.out.println("gia tri y can tim la: "+y);

    }



}
