
import java.util.*;
public class ex2 {
    public static long factorial(long n)
    {
        long tich=1;
        for (int i=1;i<=n;++i)
        {
            tich*=i;
        }
        return tich;
    }
    public static void main(String[] args) {
        System.out.println("7!+10!+12+14!= "+factorial(7)+factorial(10)+factorial(12)+factorial(14));
    }
}
