package Methods;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        matrixBuild(n);

    }

    private static void matrixBuild (int num1) {

        for (int i = 1; i <= num1 ; i++) {

            System.out.print(num1 + " ");

            for (int j = 1; j < num1; j++) {

                System.out.print(num1 + " ");

            }
            System.out.println();
        }

    }

}
