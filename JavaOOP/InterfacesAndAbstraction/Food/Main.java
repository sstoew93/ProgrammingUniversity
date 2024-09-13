package InterfacesAndAbstraction.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());

        List<Rebel> rebels = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();

        for (int person = 1; person <= count ; person++) {
            String[] input = scan.nextLine().split("\\s+");

            if (input.length == 4) {
                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String id = input[2];
                String birthDate = input[3];
                Citizen citizen = new Citizen(name, age, id , birthDate);
                citizens.add(citizen);
            } else {
                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String group = input[2];
                Rebel rebel = new Rebel(name, age , group);
                rebels.add(rebel);
            }
        }

        int totalBought = 0;
        String name = scan.nextLine();
        while (!"End".equals(name)) {
            for (Rebel rebel : rebels) {
                if (rebel.getName().equals(name)) {
                    rebel.buyFood();
                }
            }

            for (Citizen citizen : citizens) {
                if (citizen.getName().equals(name)) {
                    citizen.buyFood();
                }
            }
            name = scan.nextLine();
        }

        int total = 0;
        for (Citizen citizen : citizens) {
            total += citizen.getFood();
        }

        for (Rebel rebel : rebels) {
            total += rebel.getFood();
        }

        System.out.println(total);
    }
}
