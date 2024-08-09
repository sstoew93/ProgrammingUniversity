package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize list and fill it with stream
        List<String> input = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        //Initialize Consumer to print result
        Consumer<String> printResult = x -> System.out.println("Sir " + x);

        //Printing with Consumer
        for (String element : input) {
            printResult.accept(element);
        }

    }
}
