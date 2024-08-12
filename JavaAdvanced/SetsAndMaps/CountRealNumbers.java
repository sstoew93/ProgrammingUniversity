package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double,Integer> counter = new LinkedHashMap<>();

        //Reading input
        double[] input = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        //Fill map
        for (double number : input) {

            counter.putIfAbsent(number, 0);

            int oldValue = counter.get(number);
            counter.put(number, oldValue + 1);
        }

        //Printing map
        for (Map.Entry<Double, Integer> entry : counter.entrySet()) {
            System.out.println(String.format("%.1f -> %d", entry.getKey(), entry.getValue()));
        }

    }
}
