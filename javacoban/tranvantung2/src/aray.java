import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class aray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao các sô : ");
        int n = sc.nextInt();
        int[] so = new int[n];// tao mang
        for (int i = 0; i < n; i++) {
                so[i] = sc.nextInt();}
                int max = so[0];
                for (int i = 1; i < n; i++) {

                    if (max > so[i]);//tim so lon nhat
                    max= so[i];



                }
        System.out.println("so lon nhat la"+max);

            }
        }
