package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initialize collection and fill with numbers
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        //Initialize Function to find smallest
        Function<Integer[], Integer> findSmallestNumbers = arr -> Arrays.stream(arr).mapToInt(e -> e).min().getAsInt();

        //Printing
        int smallestNumber = findSmallestNumbers.apply(numbers);
        System.out.printf("%d", smallestNumber);
    }
}