package Methods;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String product = scan.nextLine();
        double productCount = Double.parseDouble(scan.nextLine());

        double sum = 0;

        if (product.equals("coffee")) {
            sum = coffee(productCount);
        } else if (product.equals("water")) {
           sum = water(productCount);
        } else if (product.equals("coke")) {
           sum = coke(productCount);
        } else if (product.equals("snacks")) {
           sum = snacks(productCount);
        }

        System.out.printf("%.2f",sum);

    }

    public static double coffee(double productCount) {
        return productCount * 1.5;
    }

    public static double water(double productCount) {
        return productCount * 1;
    }

    public static double coke(double productCount) {
        return productCount * 1.4;
    }

    public static double snacks(double productCount) {
        return productCount * 2;
    }

}
