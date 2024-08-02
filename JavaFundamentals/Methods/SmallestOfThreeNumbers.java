package Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        int number3 = Integer.parseInt(scan.nextLine());

        System.out.println(smallestNumberOfThree(number1,number2,number3));

    }

    private static int smallestNumberOfThree (int number1, int number2, int number3) {

        int smallestNumber = 0;

        if (number1 < number2 && number1 < number3) {
            smallestNumber = number1;
        } else if (number2 < number1 && number2 < number3) {
            smallestNumber = number2;
        } else {
            smallestNumber = number3;
        }

        return smallestNumber;
    }
}
