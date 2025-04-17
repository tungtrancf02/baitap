import java.util.*;
import java.util.Scanner;
public class bai1_ {

    String name;
    int cScore;
    int javaScore;

    public bai1_(String name, int cScore, int javaScore) {
        this.name = name;
        this.cScore = cScore;
        this.javaScore = javaScore;

    }
    public void nhap(){

        Scanner ten = new Scanner(System.in);
        System.out.println(" nhap ten cua hocj sinh 1 : ");
        String a = ten.nextLine();
        System.out.println(" nhap ten cua hocj sinh 2 : " );

    }

    public void displayInfor() {
        System.out.println("Name: " + name);

        System.out.println("Score: " + cScore);
        System.out.println("Java Score: " + javaScore);
        System.out.println(" The average of the two scores: " + ((cScore + javaScore) / 2));
    }

    public static void main(String[] args) {

        bai1_ std1 =new bai1_("Tung",90,50);
        std1.displayInfor();
        bai1_ std2 =new bai1_("thien",70,40);
        std2.displayInfor();

    }
}
