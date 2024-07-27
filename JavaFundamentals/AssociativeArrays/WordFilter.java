package AssociativeArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = Arrays.stream(scan.nextLine()
                .split(" "))
                .filter(e -> e.length() % 2 == 0)
                .toArray(String[]::new);

        for (String word:input) {
            System.out.println(word);
        }

    }
}
