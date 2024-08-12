package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize map
        Map<String, String> emailsMap = new LinkedHashMap<>();

        //Reading input
        String name = scan.nextLine();

        while (!"stop".equals(name)) {
            String email = scan.nextLine();
            if (!email.contains(".com") && !email.contains(".us") && !email.contains(".uk")) {
                emailsMap.putIfAbsent(name, email);
            }

            name = scan.nextLine();
        }

        //Printing result of approved emails
        for (Map.Entry<String, String> entry : emailsMap.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
