import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        double price = 0;

        if (budget <= 100) {
            switch (season) {
                case "summer":
                    price = budget * 0.3;
                    System.out.printf("Somewhere in Bulgaria%nCamp - %.2f", price);
                    break;
                case "winter":
                    price = budget * 0.7;
                    System.out.printf("Somewhere in Bulgaria%nHotel - %.2f", price);
                    break;
            }
        } else if (budget > 100 && budget <= 1000) {
            switch (season) {
                case "summer":
                    price = budget * 0.4;
                    System.out.printf("Somewhere in Balkans%nCamp - %.2f", price);
                    break;
                case "winter":
                    price = budget * 0.8;
                    System.out.printf("Somewhere in Balkans%nHotel - %.2f", price);
                    break;
            }
        } else if (budget > 1000) {
            switch (season) {
                case "summer":
                case "winter":
                    price = budget * 0.9;
                    System.out.printf("Somewhere in Europe%nHotel - %.2f", price);
                    break;
            }
        }




    }
}
