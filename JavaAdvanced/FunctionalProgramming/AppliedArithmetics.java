package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize list and fill with stream
        List<Integer> input = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //Initialize functions
        Function<List<Integer>,List<Integer>> add = list -> list.stream().map(x -> x + 1).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>> multiply = list -> list.stream().map(x -> x * 2).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>> subtract = list -> list.stream().map(x -> x - 1).collect(Collectors.toList());

        //Initialize Consumer to print result
        Consumer<Integer> printResult = x -> System.out.print(x + " ");

        //Reading commands
        String command = scan.nextLine();
        while (!"end".equals(command)) {

            if ("add".equals(command)) {
                input = add.apply(input);
            } else if ("multiply".equals(command)) {
                input = multiply.apply(input);
            } else if ("subtract".equals(command)) {
                input = subtract.apply(input);
            } else {
                for (Integer integer : input) {
                    printResult.accept(integer);
                }
                System.out.println();
            }

            command = scan.nextLine();
        }
    }
}
