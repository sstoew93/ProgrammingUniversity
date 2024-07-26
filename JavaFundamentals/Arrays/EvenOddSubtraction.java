package Arrays;

import java.util.Arrays;
import java.util.Scanner;


public class EvenOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();

        int sumEven = 0;
        int sumOdd = 0;

        for (int i : numbers)
        {
            if (i % 2 == 0) {
                sumEven += i;
            } else {
                sumOdd += i;
            }
        }

        System.out.println(sumEven-sumOdd);

    }
}
