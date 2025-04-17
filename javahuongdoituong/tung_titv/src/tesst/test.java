package tesst;

import model.couter_model;
import view.tang_view;

public class test {
    public static void main(String[] args) {
        couter_model coun = new couter_model();
        coun.increment();
        coun.increment();
        System.out.println(coun.getValue());
        new tang_view();
    }
}
