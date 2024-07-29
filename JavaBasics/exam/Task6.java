package exam;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxFirst = Integer.parseInt(scan.nextLine());
        int maxSecond = Integer.parseInt(scan.nextLine());
        int maxThird = Integer.parseInt(scan.nextLine());

        for (int number1 = 2; number1 <= maxFirst; number1+= 2) {

            for (int number2 = 2; number2 <= maxSecond; number2++) {

                for (int number3 = 2; number3 <= maxThird; number3+= 2) {

                    if (number2 != 4 && number2 != 6 && number2 != 8 ) {

                        System.out.printf("%d %d %d%n", number1, number2, number3);

                    }

                }

            }

        }

    }
}


