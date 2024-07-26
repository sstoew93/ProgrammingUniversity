package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();

        int magicNum = Integer.parseInt(scan.nextLine());

        int sum = 0;

        for (int i = 0; i <= numbers.length - 1; i++) {

            for (int j = i+1 ; j <= numbers.length -1; j++) {

                sum = numbers[i] + numbers[j];

                if (sum == magicNum) {
                    System.out.print(numbers[i] + " " + numbers[j]);
                    System.out.println();
                    sum = 0;
                }

            }

        }

    }
}
