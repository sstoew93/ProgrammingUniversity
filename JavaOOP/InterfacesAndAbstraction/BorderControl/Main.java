package InterfacesAndAbstraction.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Identifiable> data = new ArrayList<>();

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] split = input.split("\\s+");

            Identifiable obj;
            if (split.length == 2) {
                obj = new Robot(split[1], split[0]);
            } else {
                obj = new Citizen(split[0], Integer.parseInt(split[1]), split[2]);
            }
            data.add(obj);

            input = scan.nextLine();
        }

        String fakeID = scan.nextLine();

        for (Identifiable object : data) {
            if (object.getId().endsWith(fakeID)) {
                System.out.println(object.getId());
            }
        }
    }
}
