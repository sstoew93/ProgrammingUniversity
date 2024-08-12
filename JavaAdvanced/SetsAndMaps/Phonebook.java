package SetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize map
        Map<String,String> phonebook = new HashMap<>();

        //Reading input
        String input = scan.nextLine();
        while (!"search".equals(input)) {

            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phonebook.putIfAbsent(name, number);
            phonebook.put(name,number);


            input = scan.nextLine();
        }

        //Reading search
        String search = scan.nextLine();
        while (!"stop".equals(search)) {
            String nameToSearch = search;

            //Check number for available in map
            if (phonebook.containsKey(nameToSearch)) {
                System.out.printf("%s -> %s%n", nameToSearch, phonebook.get(nameToSearch));
            } else {
                System.out.printf("Contact %s does not exist.%n", nameToSearch);
            }
            search = scan.nextLine();
        }
    }
}
