package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());

        double result = 0;
        result = factorialOfNumbers(number1) / factorialOfNumbers(number2);

        System.out.printf("%.2f", result);

    }

    private static double factorialOfNumbers (int number) {

        double factNumber = 1;

        for (int i = 1; i <= number ; i++) {

            factNumber = factNumber * i;

        }

        return factNumber;
    }
}
