package Abstraction.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        String season = input[2];
        String discount = input[3];

        DiscountType discountType = DiscountType.valueOf(discount);
        double price = PriceCalculator.calculate(pricePerDay, days, Season.valueOf(season),discountType);
        System.out.printf("%.2f", price);
    }
}
