import java.util.Scanner;

public class bt2 {

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void printResult(int sum) {
        System.out.println("The sum from 3 to n is: " + sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n (n >= 3): ");
        int n = scanner.nextInt();

        if (n >= 3) {
            int sum = calculateSum(n);
            printResult(sum);
        } else {
            System.out.println("Invalid input. Please enter a number greater than or equal to 3.");
        }

        scanner.close();
    }
}