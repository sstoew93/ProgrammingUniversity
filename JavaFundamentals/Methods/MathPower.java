package Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double number1 = Double.parseDouble(scan.nextLine());
        double number2 = Double.parseDouble(scan.nextLine());

        System.out.println(new DecimalFormat("0.####").format(numberPow(number1, number2)));

    }

    public static double numberPow(double num1, double num2) {
        return Math.pow(num1, num2);
    }

}
