

import java.util.Scanner;



public class dowhile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("enter the number of students : ");

        int n = sc.nextInt();

        if (n <= 0)

            System.out.println(" erorr ");

        int arr[] = new int[n];

        for(int i = 0; i < n ; i++){

            do {

                System.out.printf("Enter the score number of student "+ (i+1) + " : ");

                arr[i] = sc.nextInt();

                if( arr[i] >10 || arr[i] < 0)

                    System.out.println(" erorr ");

            } while (arr[i] >10 || arr[i] < 0);

        }

        int max = arr[0];

        int count = 0 ;

        for(int i = 0 ; i < n ; i++){

            if (arr[i] >= max ) {

                max = arr[i];

            }

            if(arr[i] <= 5){

                count++;

            }



        }

        System.out.println(" the highest score of student : " + max);

        System.out.println(" the number of student with below average scores : "+ count);

        for(int i = 0; i < n ; i++) {

            if(arr[i] < 5) {

                arr[i] += 1;

            } else {

                arr[i] += 0;

            }

            System.out.println("list of studentsx scores after the increase "+ (i+1)  + " : "+ arr[i]);



        }

    }

}