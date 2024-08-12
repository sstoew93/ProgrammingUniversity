package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize set
        Set<String> parkingLot = new LinkedHashSet<>();

        //Reading input
        String input = scan.nextLine();


        while (!"END".equals(input)) {

            String[] tokens = input.split(",\\s+");

            if ("IN".equals(tokens[0])) {
                parkingLot.add(tokens[1]);
            } else {
                parkingLot.remove(tokens[1]);
            }

            input = scan.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }

        for (String s : parkingLot) {
            System.out.println(s);
        }
    }
}
