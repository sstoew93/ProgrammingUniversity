package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> setData = new LinkedHashSet<>();

        int countInputs = Integer.parseInt(scan.nextLine());

        for (int input = 0; input < countInputs; input++) {

            String line = scan.nextLine();

            setData.add(line);
        }

        for (String element : setData) {
            System.out.println(element);
        }

    }
}
