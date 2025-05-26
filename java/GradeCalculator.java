import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for marks
        System.out.print("Enter your marks (out of 100): ");
        int marks = scanner.nextInt();

        char grade;

        // Determine grade based on marks
        if (marks >= 90 && marks <= 100) {
            grade = 'A';
        } else if (marks >= 80) {
            grade = 'B';
        } else if (marks >= 70) {
            grade = 'C';
        } else if (marks >= 60) {
            grade = 'D';
        } else if (marks >= 0) {
            grade = 'F';
        } else {
            System.out.println("Invalid input! Marks should be between 0 and 100.");
            scanner.close();
            return;
        }

        // Display the result
        System.out.println("Your grade is: " + grade);
        scanner.close();
    }
}
