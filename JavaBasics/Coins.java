import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double change = Double.parseDouble(scan.nextLine());

        double coins = change * 100;
        int coinsCount = 0;

        while (coins > 0) {

            if (coins >= 200) {
                coins = coins-200;
                coinsCount++;
            } else if (coins >= 100) {
                coins = coins-100;
                coinsCount++;
            } else if (coins >= 50) {
                coins = coins-50;
                coinsCount++;
            } else if (coins >= 20) {
                coins = coins-20;
                coinsCount++;
            } else if (coins >= 10) {
                coins = coins-10;
                coinsCount++;
            }else if (coins >= 5) {
                coins = coins-5;
                coinsCount++;
            }else if (coins >= 2) {
                coins = coins-2;
                coinsCount++;
            }else if (coins >= 1) {
                coins = coins-1;
                coinsCount++;
            } else {
                break;
            }

        }

        System.out.println(coinsCount);

    }
}
