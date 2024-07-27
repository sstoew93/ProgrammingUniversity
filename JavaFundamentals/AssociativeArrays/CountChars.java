package AssociativeArrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Character, Integer> charCount = new LinkedHashMap<>();

            for (char symbol: input.toCharArray()) {

                if (symbol == ' ') {
                    continue;
                }

                if (!charCount.containsKey(symbol)) {
                    charCount.put(symbol, 1);
                } else {
                    int count = charCount.get(symbol);
                    charCount.put(symbol, count + 1);
                }

            }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {

            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());

        }


    }
}
