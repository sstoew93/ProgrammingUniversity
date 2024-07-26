package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();



        for (int index = 0; index < numbers.length - 1; index++) {
            int currentNum = numbers[index];

            boolean isBigger = true;

            for (int j = index + 1; j <= numbers.length - 1; j++) {
                int altNumbers = numbers[j];

                if ( currentNum <= altNumbers ) {
                    isBigger = false;
                    break;
                }
            }

            if (isBigger) {
                System.out.print(currentNum + " ");
            }

        }
        System.out.print(numbers[numbers.length-1]);
    }
}
