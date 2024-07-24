import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double priceCleaning = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());

        double sumMoney = 0;
        int toys = 0;

        for (int i = 1; i <= age ; i++) {

            if (i % 2 == 0) {
                sumMoney = sumMoney + (i * 5 - 1 );
            } else {
                toys++;
            }

        }

        sumMoney = toys *  toyPrice + sumMoney;

        if (sumMoney >= priceCleaning) {
            System.out.printf("Yes! %.2f", sumMoney-priceCleaning);
        } else {
            System.out.printf("No! %.2f", priceCleaning - sumMoney);
        }


    }
}
