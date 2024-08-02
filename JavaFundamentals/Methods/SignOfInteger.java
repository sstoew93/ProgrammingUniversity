package Methods;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {


        integerSign();

    }

    public static void integerSign() {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else {
            System.out.println("The number 0 is zero.");
        }
    }

}
