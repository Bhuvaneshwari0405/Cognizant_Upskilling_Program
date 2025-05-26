import java.util.*;
import java.util.stream.Collectors;

public class EvenNumbersStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 5, 8, 9, 10, 13, 14);

        List<Integer> evens = numbers.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());

        System.out.println("Even numbers: " + evens);
    }
}
