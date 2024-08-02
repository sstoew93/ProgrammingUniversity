package Methods;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scan.nextLine()));

        System.out.println(multiplyEvenOdd(evenSum(number), oddSum(number)));

    }

    private static int evenSum(int num1) {
        int evenSum = 0;

        while (num1 != 0) {
            int lastDigit = num1 % 10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            }
            num1 = num1 / 10;
        }

        return evenSum;
    }

    private static int oddSum(int num1) {
        int oddSum = 0;

        while (num1 != 0) {
            int lastDigit = num1 % 10;
            if (lastDigit % 2 != 0) {
                oddSum += lastDigit;
            }
            num1 = num1 / 10;
        }

        return oddSum;
    }

    private static int multiplyEvenOdd (int even, int odd) {
        return even * odd;
    }

}
