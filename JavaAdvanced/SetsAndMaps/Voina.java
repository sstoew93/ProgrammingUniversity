package SetsAndMaps;

import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize set for each player
        Set<Integer> firstDeck = new LinkedHashSet<>();
        Set<Integer> secondDeck = new LinkedHashSet<>();

        //Reading input
        int[] firstPlayer = Arrays.stream(scan.nextLine()
                        .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        int[] secondPlayer = Arrays.stream(scan.nextLine()
                        .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        //Fill sets from input array
        for (int card : firstPlayer) {
            firstDeck.add(card);
        }
        for (int card : secondPlayer) {
            secondDeck.add(card);
        }

        //Implement logic for game
        int rounds = 0;
        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            rounds++;

            if (rounds == 50) {
                break;
            }

            Iterator<Integer> firstIte = firstDeck.iterator();
            int firstCard = firstIte.next();
            firstIte.remove();

            Iterator<Integer> secondIte = secondDeck.iterator();
            int secondCard = secondIte.next();
            secondIte.remove();

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }

        //Printing winner
        if (firstDeck.size() < secondDeck.size()) {
            System.out.println("Second player win!");
        } else if (secondDeck.size() < firstDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
