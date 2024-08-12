package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize two sets
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        //Reading length of sets
        int[] setData = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSetElements = setData[0];
        int secondSetElements = setData[0];

        {
            int i = 0;
            while (i < firstSetElements) {
                firstSet.add(scan.nextLine());
                i++;
            }
        }
        int i = 0;
        while (i < secondSetElements) {
            secondSet.add(scan.nextLine());
            i++;
        }

        System.out.println();
        //Printing elements that contains in both sets

        for (String number1 : firstSet) {
            for (String number2 : secondSet) {
                if (number1.equals(number2)) {
                    System.out.printf("%s ", number1);
                }
            }
        }
    }
}
