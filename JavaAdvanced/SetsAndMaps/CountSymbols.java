package SetsAndMaps;

import com.sun.jdi.Value;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize map to save data into
        Map<String, Integer> dataMap = new TreeMap<>();

        String input = scan.nextLine();

        //Fill map with data
        int oldValue = 0;
        for (int i = 0; i < input.length(); i++) {

            char currentSymbol = input.charAt(i);

            dataMap.putIfAbsent(String.valueOf(currentSymbol), oldValue);
            dataMap.put(String.valueOf(currentSymbol), dataMap.get(String.valueOf(currentSymbol)) + 1);
        }

        //Print the set
        for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
