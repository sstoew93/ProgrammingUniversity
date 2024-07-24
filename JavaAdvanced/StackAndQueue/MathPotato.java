package StackAndQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> playerNames = new PriorityQueue<>();

        int cycle = 1;

        for (int i = 0; i < names.length; i++) {
            playerNames.offer(names[i]);
        }
        while (playerNames.size() > 1) {
            for (int i = 1; i < cycle; i++) {
                playerNames.offer(playerNames.poll());
            }
            if (!isPrime(cycle)) {
                System.out.printf("Removed %s%n", playerNames.poll());
            } else {
                System.out.printf("Prime %s%n",playerNames.peek());
            }
            cycle++;
        }
        System.out.printf("Last is %s%n", playerNames.poll());
    }

    private static boolean isPrime(int cycle) {
        int counter = 0;
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i <= cycle; i++) {
            if (cycle % i == 0) {
                counter++;
            }
        }
        if (counter > 1) {
            return false;
        }
        return true;
    }

}