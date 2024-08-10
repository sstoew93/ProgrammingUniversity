package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input and keep it in list
        List<Integer> input = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scan.nextLine());

        //Initialize Function and Consumer
        Predicate<Integer> isDivisible = x -> x % n == 0;
        Consumer<List<Integer>> printList = list -> list.forEach(x -> System.out.print(x + " "));

        //Modify list
        input.removeIf(isDivisible);
        Collections.reverse(input);


        //Call consumer to print
        printList.accept(input);







    }
}
