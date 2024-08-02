package Methods;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {

        triangle();

    }

    public static void triangle() {

        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = number -1; i >= 1 ; i--) {

            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");

            }
            System.out.println();
        }


    }
}
