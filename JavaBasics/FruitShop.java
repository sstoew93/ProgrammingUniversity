import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fruit = scan.nextLine();
        String day = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());

        double result = 0;

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                if (fruit.equals("banana")) {
                    result = 2.50 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("apple")) {
                    result = 1.20 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("orange")) {
                    result = 0.85 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("grapefruit")) {
                    result = 1.45 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("kiwi")) {
                    result = 2.70 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("pineapple")) {
                    result = 5.50 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("grapes")) {
                    result = 3.85 * quantity;
                    System.out.printf("%.2f", result);
                } else {
                    System.out.println("error");
                }
            break;
            case "Saturday":
            case "Sunday":
                if (fruit.equals("banana")) {
                    result = 2.70 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("apple")) {
                    result = 1.25 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("orange")) {
                    result = 0.90 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("grapefruit")) {
                    result = 1.60 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("kiwi")) {
                    result = 3.00 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("pineapple")) {
                    result = 5.60 * quantity;
                    System.out.printf("%.2f", result);
                } else if (fruit.equals("grapes")) {
                    result = 4.20 * quantity;
                    System.out.printf("%.2f", result);
                } else {
                    System.out.println("error");
                }
            break;
            default:
                System.out.println("error");
            break;



        }

    }
}