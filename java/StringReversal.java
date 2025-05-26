import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        StringBuilder reversed = new StringBuilder(str).reverse();
        System.out.println("Reversed string: " + reversed);
        input.close();
    }
}
