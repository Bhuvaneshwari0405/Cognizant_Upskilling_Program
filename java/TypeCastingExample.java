public class TypeCastingExample {
    public static void main(String[] args) {
        // Declare a double variable
        double myDouble = 9.75;
        System.out.println("Original double value: " + myDouble);

        // Cast double to int (explicit casting)
        int myInt = (int) myDouble;
        System.out.println("Double casted to int: " + myInt);

        // Declare an int variable
        int anotherInt = 5;
        System.out.println("Original int value: " + anotherInt);

        // Cast int to double (implicit casting)
        double anotherDouble = anotherInt;
        System.out.println("Int casted to double: " + anotherDouble);
    }
}

