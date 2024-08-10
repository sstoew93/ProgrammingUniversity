package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Variant 1
        List<String> input = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        int sum = input.stream().mapToInt(Integer::parseInt).sum();

        System.out.printf("Count = %s%nSum = %d", input.size(), sum);

        //Variant 2
        Function<String, Integer> func = Integer::parseInt;

        List<Integer> result = Arrays.stream(scan.nextLine()
                .split(",\\s+"))
                .map(func)
                .collect(Collectors.toList());
        int sum2 = result.stream().mapToInt(Integer::intValue).sum();

        System.out.printf("Count = %d%nSum = %d", result.size(), sum2);

    }
}
