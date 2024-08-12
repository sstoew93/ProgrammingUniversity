package SetsAndMaps;

import java.util.*;

public class HandOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize map to save players data
        Map<String, List<String>> playerData = new LinkedHashMap<>();

        //Fill map with data
        String input = scan.nextLine();
        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(": ");
            String playerName = tokens[0];
            String[] playerCards = tokens[1].split(", ");

            playerData.putIfAbsent(playerName, new ArrayList<>());

            //Enter all cards into List
            for (int i = 0; i < playerCards.length; i++) {
                String card = playerCards[i];
                if (!playerData.get(playerName).contains(card)) {
                    playerData.get(playerName).add(card);
                }
            }
            //Re-read input
            input = scan.nextLine();
        }

        //Create method to implement logic for sum of cards
        sumCardsPrint(playerData);

    }

    private static void sumCardsPrint(Map<String, List<String>> playerData) {
        for (Map.Entry<String, List<String>> player : playerData.entrySet()) {
            int sum = 0;
            //Summing of cards
            for (String card : player.getValue()) {

                String powerCh = "";
                String type = "";
                if (card.length() > 2) {
                    powerCh = "10";
                    type = String.valueOf(card.charAt(2));
                } else {
                    powerCh = String.valueOf(card.charAt(0));
                    type = String.valueOf(card.charAt(1));
                }

                //Check card power
                int power = 0;
                int multipliers = 0;
                if ("J".equals(powerCh)) {
                    power = 11;
                } else if ("Q".equals(powerCh)) {
                    power = 12;
                } else if ("K".equals(powerCh)) {
                    power = 13;
                } else if ("A".equals(powerCh)) {
                    power = 14;
                } else if ("1".equals(powerCh)) {
                    power = 1;
                } else if ("2".equals(powerCh)) {
                    power = 2;
                } else if ("3".equals(powerCh)) {
                    power = 3;
                } else if ("4".equals(powerCh)) {
                    power = 4;
                } else if ("5".equals(powerCh)) {
                    power = 5;
                } else if ("6".equals(powerCh)) {
                    power = 6;
                } else if ("7".equals(powerCh)) {
                    power = 7;
                } else if ("8".equals(powerCh)) {
                    power = 8;
                } else if ("9".equals(powerCh)) {
                    power = 9;
                } else {
                    power = 10;
                }

                //Check type of card
                if ("S".equals(type)) {
                    multipliers = 4;
                } else if ("H".equals(type)) {
                    multipliers = 3;
                } else if ("D".equals(type)) {
                    multipliers = 2;
                } else {
                    multipliers = 1;
                }

                sum = sum + (power * multipliers);
            }

            //Print player and sum of his cards
            System.out.printf("%s: %d%n", player.getKey(), sum);
        }
    }
}

