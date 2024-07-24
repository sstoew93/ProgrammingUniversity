import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        double credit = 0;

        while (!command.equals("Start")) {
            double coin = Double.parseDouble(command);

            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 ||coin == 2) {
                credit += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }

            command = scan.nextLine();
        }

        String product = scan.nextLine();

        while (!product.equals("End")) {
            switch (product) {
                case "Nuts":
                    if (credit >= 2) {
                        credit -= 2;
                        System.out.printf("Purchased %s%n", product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (credit >= 0.7) {
                        credit -= 0.7;
                        System.out.printf("Purchased %s%n", product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (credit >= 1.5) {
                        credit -= 1.5;
                        System.out.printf("Purchased %s%n", product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (credit >= 0.8) {
                        credit -= 0.8;
                        System.out.printf("Purchased %s%n", product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (credit >= 1) {
                        credit -= 1;
                        System.out.printf("Purchased %s%n", product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            product = scan.nextLine();
        }

        System.out.printf("Change: %.2f", credit);

    }
}
