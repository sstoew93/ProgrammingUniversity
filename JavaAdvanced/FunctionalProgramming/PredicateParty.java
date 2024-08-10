package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> predicate;

        //Reading input
        List<String> guests = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))

                .collect(Collectors.toList());

        //Read commands
        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");
            if (tokens[1].equals("StartsWith")) {
                predicate = s -> s.startsWith(tokens[2]);
            } else if (tokens[1].equals("EndsWith")) {
                predicate = s -> s.endsWith(tokens[2]);
            } else {
                predicate = s -> s.length() == Integer.parseInt(tokens[2]);
            }
            if (tokens[0].equals("Remove")) {
                guests.removeIf(predicate);
            } else if (tokens[0].equals("Double")) {
                List<String> guestDouble = guests.stream().filter(predicate).collect(Collectors.toList());
                guests.addAll(guestDouble);
            }
            command = scanner.nextLine();
        }

        //Result
        if (guests.isEmpty()) {
            System.out.printf("Nobody is going to the party!%n");
        } else {
            String print = guests.stream().sorted().collect(Collectors.joining(", "));
            System.out.printf("%s are going to the party!%n", print);
        }
    }
}
