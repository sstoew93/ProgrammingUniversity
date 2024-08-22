package Abstraction.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        CardRank[] ranks = CardRank.values();

        if ("Card Ranks".equals(input)) {
            System.out.println("Card Ranks:");
            for (CardRank rank : ranks) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(),rank);
            }
        }

    }
}
