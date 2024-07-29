import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int budget = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int people = Integer.parseInt(scan.nextLine());

        double price = 0;



        if (season.equals("Spring")){
            price = 3000;
        }else if(season.equals("Summer")||season.equals("Autumn")){
            price = 4200;
        }else if(season.equals("Winter")){
            price = 2600;
        }
        if (people <= 6){
            price = price - price * 0.1;
        }else if (people >= 7 && people <= 11){
            price = price - price * 0.15;
        }else if (people >= 12){
            price = price - price * 0.25;
        }
        if (people % 2 == 0 && (season.equals("Spring") || season.equals("Summer")|| season.equals("Winter"))){
            price = price - price * 0.05;
        }
        double diff = Math.abs(budget-price);
        if (budget < price){
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        } else {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        }
    }
}