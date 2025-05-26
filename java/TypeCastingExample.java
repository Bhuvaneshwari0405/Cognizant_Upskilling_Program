public class TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.75;
        System.out.println("Original double value: " + myDouble);

        int myInt = (int) myDouble;
        System.out.println("Double casted to int: " + myInt);

        int anotherInt = 5;
        System.out.println("Original int value: " + anotherInt);

        double anotherDouble = anotherInt;
        System.out.println("Int casted to double: " + anotherDouble);
    }
}

