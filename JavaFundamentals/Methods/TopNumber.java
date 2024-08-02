package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxRange = Integer.parseInt(scan.nextLine());

        for (int currentNumber = 1; currentNumber <= maxRange ; currentNumber++) {

            boolean isDivisibleBy8 = isDivisibleBy8(maxRange);
            boolean isHoldsOddNumber = isHoldsOddNumber(maxRange);

            if (isDivisibleBy8(currentNumber) && (isHoldsOddNumber(currentNumber))) {
                    System.out.println(currentNumber);
            }

        }

    }

    private static boolean isDivisibleBy8(int number) {
        int sumOfDigits = 0;
        int lastDigit = 0;

        while (number > 0) {

            lastDigit = number % 10;
            sumOfDigits += lastDigit;
            number = number / 10;

        }

        if (sumOfDigits % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isHoldsOddNumber (int number) {
        int lastDigit = 0;
        while (number > 0) {

            lastDigit = number % 10;

            if (lastDigit % 2 != 0) {
                return true;
            } else {
                number = number / 10;
            }
        }
        return false;
    }
 }
