import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.println("Enter student names (type 'stop' to finish):");
        while (true) {
            String name = input.nextLine();
            if (name.equalsIgnoreCase("stop")) break;
            names.add(name);
        }

        System.out.println("Student names entered:");
        for (String n : names) {
            System.out.println(n);
        }
        input.close();
    }
}
