package Abstraction.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input1 = scan.nextLine();
        String input2 = scan.nextLine();

        Card card = new Card(RankPowers.valueOf(input1), Suits.valueOf(input2));

        System.out.printf("Card name: %s of %s; Card power: %d%n", RankPowers.valueOf(input1), Suits.valueOf(input2), card.getPower());
    }
}
