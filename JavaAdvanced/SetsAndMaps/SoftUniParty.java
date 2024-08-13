package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize set to save all invited guests
        Set<String> invitedGuests = new TreeSet<>();

        String input = scan.nextLine();

        //Add all invited guests
        while (!"PARTY".equals(input)) {
            invitedGuests.add(input);

            input = scan.nextLine();
        }

        String visit = scan.nextLine();

        //Remove from Set guest who didn't come
        while (!"END".equals(visit)) {

            invitedGuests.remove(visit);

            visit = scan.nextLine();
        }

        //Printing guest who didn't come count
        System.out.println(invitedGuests.size());

        //Printing guest who didn't come
        for (String visitor : invitedGuests) {
            System.out.println(visitor);
        }

    }
}
