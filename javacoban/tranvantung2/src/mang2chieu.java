import java.util.Scanner;

public class mang2chieu
{
    public static void main(String[] args) {

        int max0, max1;
        int tong=0,tong1=0;

        int[][] myNumbers = {{1, 2, 3, 4,}, {5, 6, 7,}};
        max0 = myNumbers[0][0];
        max1 = myNumbers[1][0];

        for (int i = 0; i < myNumbers.length; i++) {
            for (int j = 0; j < myNumbers[i].length; j++) {
                System.out.println(myNumbers[i][j]);


                if (i == 0 && max0 < myNumbers[0][j]) {
                    max0 = myNumbers[0][j];
                }
                if (i == 1 && max1 < myNumbers[1][j]) {
                    max1 = myNumbers[1][j];
                }
                if (i==0 ){
                    tong=tong+myNumbers[0][j];}
                if (i==1 ){
                    tong1=tong1+myNumbers[1][j];}

            }


        }
        System.out.println("max = " + max0);
        System.out.println("max1 = " + max1);
        if (max0 > max1) {
        System.out.println(max0);}
        else System.out.println(max1);
        System.out.println("tong = " + tong);
        System.out.println("tong1= "+tong1);
        System.out.println("tong cua hai mang="+(tong+tong1));
    }
}




