package Abstraction.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        CardSuit[] cardSuits = CardSuit.values();
        if ("Card Suits".equals(input)) {
            System.out.println("Card Suits:");

            for (CardSuit cardSuit : cardSuits) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit);
            }

        }
    }
}
