package Encapsulation.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pizza pizza = null;

        String command = scan.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split("\\s+");
            String currentCommand = commandParts[0];
            if (currentCommand.equals("Pizza")) {
                pizza = new Pizza(commandParts[1], Integer.parseInt(commandParts[2]));
            } else if (currentCommand.equals("Dough")) {
                Dough dough = new Dough(commandParts[1], commandParts[2], Integer.parseInt(commandParts[3]));
                pizza.setDough(dough);
            } else if (currentCommand.equals("Topping")) {
                Topping topping = new Topping(commandParts[1], Integer.parseInt(commandParts[2]));
                pizza.addTopping(topping);
            }
            command = scan.nextLine();
        }
        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
    }
}

