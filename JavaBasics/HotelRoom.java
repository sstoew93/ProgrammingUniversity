import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());

        double priceStudio = 0;
        double priceApartment = 0;

        switch (month) {
            case "May":
            case "October":
                priceStudio = 50 * nights;
                priceApartment = 65 * nights;
                if (nights > 14) {
                    priceApartment = priceApartment * 0.9;
                    priceStudio = priceStudio * 0.7;
                } else if (nights > 7) {
                    priceStudio = priceStudio - priceStudio * 0.05;
                }
                //System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", priceApartment, priceStudio);
                break;
            case "June":
            case "September":
                priceStudio = 75.20 * nights;
                priceApartment = 68.70 * nights;
                if (nights > 14) {
                    priceApartment = priceApartment - priceApartment * 0.1;
                    priceStudio = priceStudio - priceStudio * 0.2;
                }
                //System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", priceApartment, priceStudio);
                break;
            case "July":
            case "August":
                priceStudio = 76 * nights;
                priceApartment = 77 * nights;
                if (nights > 14) {
                    priceApartment = priceApartment - priceApartment * 0.1;
                }
                //System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", priceApartment, priceStudio);
                break;
        }
        System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", priceApartment, priceStudio);

    }
}
