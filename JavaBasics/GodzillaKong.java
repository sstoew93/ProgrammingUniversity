import java.util.Scanner;

public class GodzillaKong {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int staff = Integer.parseInt(scan.nextLine());
        double priceStaff = Double.parseDouble(scan.nextLine());


        if (staff > 150) {
            priceStaff = priceStaff - priceStaff * 0.10;
        }

        double decor = budget * 0.1;
        double priceClothes = staff * priceStaff;
        double fullPrice = decor + priceClothes;
        double lastPrice = fullPrice - budget;

        double diff = Math.abs(lastPrice);
        if (fullPrice > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);

        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        }

    }
}
