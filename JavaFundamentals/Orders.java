import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int order = Integer.parseInt(scan.nextLine());

        double fullPrice = 0;

        for (int i = 1; i <= order ; i++) {

            double pricePerOneUnit = Double.parseDouble(scan.nextLine());
            int days = Integer.parseInt(scan.nextLine());
            int capsulesCount = Integer.parseInt(scan.nextLine());

            double orderPrice = ( days * capsulesCount ) * pricePerOneUnit;

            System.out.printf("The price for the coffee is: $%.2f%n", orderPrice);

            fullPrice += orderPrice;

        }

        System.out.printf("Total: $%.2f", fullPrice);

    }
}
