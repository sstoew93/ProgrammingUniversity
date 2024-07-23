package AssociativeArrays;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        LinkedHashMap<String, Double> productPrice = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productQuantity = new LinkedHashMap<>();
        LinkedHashMap<String,Double> finalPrice = new LinkedHashMap<>();

        while (!input[0].equals("buy")) {

            String product = input[0];
            double price = Double.parseDouble(input[1]);
            int quantity = Integer.parseInt(input[2]);

            if (!productPrice.containsKey(product)) {
                productPrice.put(product,price);
                productQuantity.put(product,quantity);
            } else {
                int currentQuantity = productQuantity.get(product);
                productQuantity.put(product, currentQuantity + quantity);

                double currentPrice = productPrice.get(product);
                if (currentPrice != price) {
                    productPrice.put(product, price);
                }

            }

            finalPrice.put(product, productQuantity.get(product) * productPrice.get(product));


        input = scan.nextLine().split(" ");
        }

        for (Map.Entry<String, Double> entry : finalPrice.entrySet()) {

            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());

        }


    }
}
