import java.util.Scanner;

public class FoodDelivery {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

            int chicken = Integer.parseInt(scan.nextLine());
            int fish = Integer.parseInt(scan.nextLine());
            int vegetarian = Integer.parseInt(scan.nextLine());

            double delivery = 2.50;
            double priceChicken = chicken * 10.35;
            double priceFish = fish * 12.40;
            double priceVegetarian = vegetarian * 8.15;

            double priceOrder = priceChicken + priceFish + priceVegetarian;
            double dessertPrice = priceOrder * ( 20 / 100.0 );
            double lastPrice = priceOrder + dessertPrice + delivery;

        System.out.println(lastPrice);


    }
}
