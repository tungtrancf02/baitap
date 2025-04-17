import javax.crypto.spec.PSource;
import java.sql.SQLOutput;
import java.util.Scanner;


public class ifelse2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhpa chieu cao cua b");
        Double CAO = sc.nextDouble();
        System.out.println("nhap can nang cua b");
        double nang = sc.nextDouble();

        double BMI = nang / (Math.pow(CAO, 2));
        System.out.println(BMI);
        if (BMI < 15)
            System.out.println("than hinh qua gay");
        else if (BMI >= 15 && BMI < 18.5)
            System.out.println(" than hih hoi gay");
        else if (BMI >= 18.5 && BMI < 24.5)
            System.out.println(" than hinh binh thyong");
        else if (BMI >= 24.5 && BMI < 29.5)
            System.out.println("hoi beo");
        else if (BMI >= 29.5)
            System.out.println(" beo");
        else if (BMI >= 30.5)
            System.out.println(" qua beo");



    }
}
