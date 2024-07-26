package Arrays;

import java.util.Scanner;

public class PrintNumberReverseOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

                int[] numbers = new int[n];

                for (int i = 0; i < n; i++) {
                    int number = Integer.parseInt(scan.nextLine());
                    numbers[i] = number;
                }

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }


    }
}
