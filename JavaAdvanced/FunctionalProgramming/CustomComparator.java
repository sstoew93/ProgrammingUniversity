package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Reading input array
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        //Initialize comparator
        Comparator<Integer> comparator = (first, seconds) -> {
            if (first % 2 == 0 && seconds % 2 != 0) {
                return -1;
            }
            if (first % 2 != 0 && seconds % 2 == 0) {
                return 1;
            }
            return first.compareTo(seconds);
        };

        //Call comparator
        Arrays.sort(numbers, comparator);

        //Print result
        Arrays.stream(numbers).forEach(n -> System.out.printf("%d ", n));
    }
}
