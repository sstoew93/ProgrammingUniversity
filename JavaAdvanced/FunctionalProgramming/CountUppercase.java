package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize functions
        Predicate<String> isUpper = string -> Character.isUpperCase(string.charAt(0));
        Consumer<String> printResult = string -> System.out.println(string);

        //Fill array with stream filter
        List<String> results = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .filter(isUpper)
                .collect(Collectors.toList());

        //Print
        System.out.println(results.size());
        results.forEach(printResult);



    }
}
