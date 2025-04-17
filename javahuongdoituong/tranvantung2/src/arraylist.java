import java.util.ArrayList;
import java.util.Collections;
public class arraylist {
    public static void main(String[] args) {
        ArrayList<String> car =new ArrayList<String>();
        car.add("Toyota");
        car.add("BMW");
        car.add("Audi");
        car.add("Volvo");
        Collections.sort(car);// đảo
        for (String i : car)
            System.out.println(i);
        // | for (int i=0; i<= car.size(); i++)
        //sout (i)
    }
}
