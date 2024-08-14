package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;
public class Voina2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Initialize sets and fill them from input
        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));


        //Implement logic
        for (int i = 0; i < 50; i++) {
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
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
            } else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }
        //Printing result
        if (firstDeck.size() > secondDeck.size()) {
            System.out.printf("First player win!%n");
        } else if (firstDeck.size() < secondDeck.size()) {
            System.out.printf("Second player win!%n");
        } else {
            System.out.printf("Draw!%n");
        }
    }
}