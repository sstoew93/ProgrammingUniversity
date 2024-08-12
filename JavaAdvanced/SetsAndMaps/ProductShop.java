package SetsAndMaps;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize map
        Map<String, Map<String, Double>>data = new TreeMap<>();

        //Read input
        String input = scan.nextLine();

        //Fill map with data from input
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(",\\s+");
            String shop = tokens[0];
            String item = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            data.putIfAbsent(shop, new LinkedHashMap<>());
            data.get(shop).putIfAbsent(item, price);

            input = scan.nextLine();
        }

        //Printing map with method
        printMap(data);
    }

    private static void printMap(Map<String, Map<String, Double>> data) {

        for (Map.Entry<String, Map<String, Double>> shop : data.entrySet()) {
            System.out.printf("%s->%n", shop.getKey());

            for (Map.Entry<String, Double> product : shop.getValue().entrySet()) {

                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }

        }
    }
}
