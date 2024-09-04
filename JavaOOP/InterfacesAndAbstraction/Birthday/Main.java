package InterfacesAndAbstraction.Birthday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Birthable> birthable = new ArrayList<>();

        while (!"End".equals(input)) {
            String type = input.split("\\s+")[0];

            if ("InterfacesAndAbstraction.Birthday.Citizen".equals(type)) {
                String name = input.split("\\s+")[1];
                int age = Integer.parseInt(input.split("\\s+")[2]);
                String id = input.split("\\s+")[3];
                String birthDate = input.split("\\s+")[4];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                birthable.add(citizen);
            } else if ("InterfacesAndAbstraction.Birthday.Pet".equals(type)) {
                String name = input.split("\\s+")[1];
                String birthDate = input.split("\\s+")[2];
                Pet pet = new Pet(name, birthDate);
                birthable.add(pet);
            } else {
                String model = input.split("\\s+")[1];
                String id = input.split("\\s+")[2];
                Robot robot = new Robot(id,model);
            }

            input = scan.nextLine();
        }

        String year = scan.nextLine();

        for (Birthable birth : birthable) {
            if(birth.getBirthDate().endsWith(year)) {
                System.out.println(birth.getBirthDate());
            }
        }
    }
}
