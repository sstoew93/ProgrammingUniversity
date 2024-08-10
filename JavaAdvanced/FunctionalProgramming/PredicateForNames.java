package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input
        int maxLength = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        //Initialize Predicate to check if name is valid
        Predicate<String> isValid = string -> string.length() <= maxLength;

        //Filter valid names with predicate
        List<String> validNames = Arrays.stream(names).filter(isValid).collect(Collectors.toList());

        for (String validName : validNames) {
            System.out.println(validName);
        }
    }
}
