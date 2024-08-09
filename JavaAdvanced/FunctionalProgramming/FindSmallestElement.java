package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read input and fill in list
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //Function to find smallest element
        Function<List<Integer>, Integer> findSmallest = list -> Collections.min(list);
        int smallestNumber = findSmallest.apply(numbers);

        //Find index of smallest element
        for (int index = numbers.size() - 1; index >= 0 ; index--) {
            if (numbers.get(index) == smallestNumber) {
                System.out.println(index);
                break;
            }
        }

    }
}