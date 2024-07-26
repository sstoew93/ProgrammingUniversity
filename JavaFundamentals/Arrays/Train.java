package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int wagonsCount = Integer.parseInt(scan.nextLine());

        int[] wagons = new int[wagonsCount];

        for (int wagon = 0; wagon <= wagonsCount - 1 ; wagon++) {
            int countPeople = Integer.parseInt(scan.nextLine());
            wagons[wagon] = countPeople;
        }

        int sum = 0;

        for (int number : wagons) {
            System.out.print(number + " ");
            sum += number;
        }

        System.out.println();
        System.out.println(sum);



    }
}
