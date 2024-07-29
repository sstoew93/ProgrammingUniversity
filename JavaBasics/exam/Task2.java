package exam;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int missingDays = Integer.parseInt(scan.nextLine());
        int allFoodLeft = Integer.parseInt(scan.nextLine());
        double dearOneFood = Double.parseDouble(scan.nextLine());
        double dearTwoFood = Double.parseDouble(scan.nextLine());
        double dearThreeFood = Double.parseDouble(scan.nextLine());

        double foodDearOne = missingDays * dearOneFood;
        double foodDearTwo = missingDays * dearTwoFood;
        double foodDearThree = missingDays * dearThreeFood;

        double neededFoodSum = foodDearOne+foodDearTwo+foodDearThree;

        if (neededFoodSum <= allFoodLeft) {

            System.out.printf("%.0f kilos of food left.", Math.floor(allFoodLeft-neededFoodSum));

        } else {

            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(neededFoodSum-allFoodLeft));

        }


    }
}
