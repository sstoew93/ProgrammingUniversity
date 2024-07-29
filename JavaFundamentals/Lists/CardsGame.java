package Lists;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> playerOneDeck = Arrays.stream(scan.nextLine()
                        .split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> playerTwoDeck = Arrays.stream(scan.nextLine()
                        .split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (playerTwoDeck.size() != 0 && playerOneDeck.size() != 0) {

                int currentCard1 = playerOneDeck.get(0);
                int currentCard2 = playerTwoDeck.get(0);

                playerOneDeck.remove(0);
                playerTwoDeck.remove(0);

                if (currentCard1 > currentCard2) {

                    playerOneDeck.add(currentCard1);
                    playerOneDeck.add(currentCard2);

                } else if (currentCard2 > currentCard1) {

                    playerTwoDeck.add(currentCard2);
                    playerTwoDeck.add(currentCard1);

                }
            }

        int sum1 = 0;
        int sum2 = 0;

        for (int sum: playerOneDeck) {
            sum1 += sum;
        }

        for (int sum: playerTwoDeck) {
            sum2 += sum ;
        }
        if (sum1 > sum2) {
            System.out.printf("First player wins! Sum: %d", sum1);
        } else {
            System.out.printf("Second player wins! Sum: %d", sum2);
        }

    }
}
