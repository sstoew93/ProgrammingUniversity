package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read input, modify and then print
        String result = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(result);

        //Sort in ascending order and print
        String collect = Arrays.stream(result.split(", "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(collect);

    }
}
