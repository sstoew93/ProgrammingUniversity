package Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] personsInput = scan.nextLine().split(";");
        String[] productInput = scan.nextLine().split(";");

        List<Person> persons = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        for (String s : personsInput) {
            String[] personData = s.split("=");
            Person person = new Person(personData[0], Double.parseDouble(personData[1]));
            persons.add(person);
        }

        for (String s : productInput) {
            String[] productData = s.split("=");
            Product product = new Product(productData[0], Double.parseDouble(productData[1]));
            products.add(product);
        }

        String command = scan.nextLine();
        while (!"END".equals(command)) {
            String[] data = command.split("\\s+");

            String name = data[0];
            String productName = data[1];

            for (Person person : persons) {
                if (person.getName().equals(name)) {
                    for (Product product : products) {
                        if (product.getName().equals(productName)) {
                            try {
                                person.buyProduct(product);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }

            command = scan.nextLine();
        }

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
