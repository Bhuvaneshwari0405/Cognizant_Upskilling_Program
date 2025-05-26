import java.util.Scanner;

public class RecursiveFibonacci {
    
    // Recursive method to calculate nth Fibonacci number
    public static int fibonacci(int n) {
        // Base cases
        if (n == 1 || n == 2) {
            return 1;
        }

        // Recursive call
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Recursive Fibonacci Calculator!");
        System.out.print("Enter a positive integer (n): ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive number greater than 0.");
        } else {
            int result = fibonacci(n);
            System.out.println("The " + n + "th Fibonacci number is: " + result);
        }

        input.close(); // Always good to close the scanner
    }
}
