import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Factorial Calculator!");
        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        // Check if the user entered a valid non-negative number
        if (number < 0) {
            System.out.println("Oops! Factorial is not defined for negative numbers.");
        } else {
            long factorial = 1; // We use long to handle large factorial results

            // Calculate factorial using a for loop
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            // Display the result
            System.out.println("The factorial of " + number + " is: " + factorial);
        }

        input.close(); // Close the scanner
    }
}
