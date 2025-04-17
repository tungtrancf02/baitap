public class bai1opp {
    private String id;
    private String name;
    private int age;
    private double gpa;

    public bai1opp(String id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;

    }

    public void displayInfor() {
        System.out.println("ma sinh vien : " + id);
        System.out.println("ma sinh vien : " + name);
        System.out.println("ma sinh vien : " + age);
        System.out.println("ma sinh vien : " + gpa);
    }

    public void isPasser() {
        if (gpa >= 5 && gpa <= 10)
            System.out.println("true");
        else System.out.println("false");
    }

    public class student {
        public static void main(String[] args) {
            bai1opp hcosinh1=new bai1opp("24it3","tung",18,6);
            hcosinh1.displayInfor();
            System.out.println();
            bai1opp hocsinh2=new bai1opp("24it22","sang",18,5);
            hocsinh2.displayInfor();
            System.out.println();
            bai1opp hocsinh3=new bai1opp("24it42","thien",18,4);
            hocsinh3.displayInfor();
            System.out.println();

        }
    }
}