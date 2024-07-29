package Lists;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scan.nextLine()
                        .split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();

        while (!command.equals("end")) {

            String[] commandParts = command.split(" ");



            if (commandParts[0].equals("Add")) {
                //String commandType = commandParts[0];
                int passengersToAdd = Integer.parseInt(commandParts[1]);
                wagons.add(passengersToAdd);
            } else {
                int passengersToAdd = Integer.parseInt(commandParts[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int wagonSize = wagons.get(i);

                    if (wagonSize + passengersToAdd <= maxCapacity) {
                        wagons.set(i, wagonSize + passengersToAdd);
                        break;
                    }

                }

            }

            command = scan.nextLine();
        }
        System.out.println();

        for (int wagon: wagons) {

            System.out.print(wagon + " ");

        }

    }
}
