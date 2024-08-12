package SetsAndMaps;

import java.util.Scanner;
import java.util.*;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> set = new TreeSet<>();

        int[] inputArr = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int element = 0; element < inputArr.length; element++) {
            set.add(inputArr[element]);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.reverse(list);

        while (list.size() > 3) {
            list.remove(list.size() - 1);
        }

        for (Integer numberToPrint : list) {
            System.out.printf("%d ", numberToPrint);
        }

    }
}

