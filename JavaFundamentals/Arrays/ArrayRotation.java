package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();
        int rotations = Integer.parseInt(scan.nextLine());

        int currentNum = 0;

        for (int rotation = 0; rotation < rotations; rotation++) {
            currentNum = numbers[0];

            for (int index = 0; index < numbers.length - 1 ; index++) {
                numbers[index] = numbers[index + 1];
            }

           numbers[numbers.length-1] = currentNum;
        }
        System.out.println(Arrays.toString(numbers)
                .replace("[", "")
                .replace("]","")
                .replace(",", ""));
    }
}
