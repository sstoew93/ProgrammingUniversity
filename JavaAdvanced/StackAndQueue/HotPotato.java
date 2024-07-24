package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Reading input
        String[] players = scan.nextLine().split("\\s+");
        int cycle = Integer.parseInt(scan.nextLine());

        //Defining a queue
        Deque<String> playerNames = new ArrayDeque<>();

        // Add players to queue
        for (String player : players) {
            playerNames.offer(player);
        }

        // Logic
        while (playerNames.size() > 1) {

            for (int i = 1; i < cycle; i++) {
                playerNames.offer(playerNames.poll());
            }

            System.out.println("Removed " + playerNames.poll());

        }

        System.out.println("Last is " + playerNames.poll());

    }
}
