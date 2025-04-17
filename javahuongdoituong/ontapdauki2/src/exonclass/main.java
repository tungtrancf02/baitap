package exonclass;

public class main {

        public static void main(String[] args) {
            // Test Constructors and toString()
            ex1_2 c1 = new ex1_2(1.1);
            System.out.println(c1);   // toString()
            ex1_2 c2 = new ex1_2(); // default constructor
            System.out.println(c2);

            // Test setter and getter
            c1.setradius(2.2);
            System.out.println(c1);      // toString()
            System.out.println("radius is: " + c1.getradius());

            // Test getArea() and getCircumference()
            System.out.printf("area is: %.2f%n", c1.getArea());
            System.out.printf("circumference is: %.2f%n", c1.getCircumference());
        }

}
