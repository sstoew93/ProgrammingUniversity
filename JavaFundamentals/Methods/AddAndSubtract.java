package Methods;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        int number3 = Integer.parseInt(scan.nextLine());

        int result = subtractTwoNumbers(addTwoNumbers(number1, number2),number3);

        System.out.println(result);

    }

    private static int addTwoNumbers (int num1, int num2) {
        return num1+num2;
    }

    private static int subtractTwoNumbers (int num1, int num2) {
        return num1 - num2;
    }
}
