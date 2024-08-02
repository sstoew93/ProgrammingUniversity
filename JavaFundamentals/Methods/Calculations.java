package Methods;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        int result = 0;

        if (command.equals("add")) {
           result =  add(num1,num2);
        } else if (command.equals("multiply")) {
            result = multiply(num1,num2);
        } else if (command.equals("subtract")) {
            result = subtract(num1,num2);
        } else {
            result = divide(num1,num2);
        }

        System.out.println(result);

    }

    public static int add (int number1, int number2) {
        return number1 + number2;
    }

    public static int multiply (int number1, int number2) {
        return number1 * number2;
    }

    public static int subtract (int number1, int number2) {
        return number1 - number2;
    }

    public static int divide (int number1, int number2) {
        return number1 / number2;
    }
}
