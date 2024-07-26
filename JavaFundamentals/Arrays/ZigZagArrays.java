package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int [] array1 = new int[n];
        int [] array2 = new int[n];

        for (int i = 1; i <= n ; i++) {
            String numbers = scan.nextLine();

            int firstNum = Integer.parseInt(numbers.split(" ")[0]);
            int secondNum = Integer.parseInt(numbers.split(" ")[1]);

            if (i % 2 == 0) {
                array1[i-1] = secondNum;
                array2[i-1] = firstNum;
            } else {
                array1[i-1] = firstNum;
                array2[i-1] = secondNum;
            }


        }

        for ( int number:array1) {
            System.out.print(number + " ");
        }

        System.out.println();
        for (int number:array2) {
            System.out.print(number + " ");
        }
    }
}
