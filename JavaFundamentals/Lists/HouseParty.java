package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int guestsCount = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 1; i <= guestsCount ; i++) {
            String command = scan.nextLine();

            String[] commandElements = command.split(" ");

            String name = commandElements[0];

            if (command.contains("not")) {

                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }

            } else {

                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guests.add(name);
                }

            }

        }

        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}
