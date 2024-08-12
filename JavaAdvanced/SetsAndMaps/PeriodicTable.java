package SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize set to save data
        Set<String> elements = new TreeSet<>();

        //Reading count of elements
        int count = Integer.parseInt(scan.nextLine());

        //Save elements
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine()
                    .split("\\s+");

            //Add all element from input into set
            //elements.addAll(Arrays.asList(input));
            for (int j = 0; j < input.length; j++) {
                elements.add(input[j]);
            }
        }

        //Printing set
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
