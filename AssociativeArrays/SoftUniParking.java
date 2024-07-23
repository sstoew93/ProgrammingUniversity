package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, String> registered = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {

            String[] commandParts = scan.nextLine().split(" ");

            String command = commandParts[0];
            String driver = commandParts[1];

            if (command.equals("register")) {

                String licensePlate = commandParts[2];

                if (registered.containsKey(driver)) {

                    System.out.printf("ERROR: already registered with plate number %s%n", licensePlate);

                } else {

                    registered.put(driver, licensePlate);
                    System.out.printf("%s registered %s successfully%n", driver, licensePlate);

                }

            } else {

                if (!registered.containsKey(driver)) {

                    System.out.printf("ERROR: user %s not found%n", driver);

                } else {

                    registered.remove(driver);
                    System.out.printf("%s unregistered successfully%n", driver);

                }
            }

        }

        for (Map.Entry<String, String> entry : registered.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
