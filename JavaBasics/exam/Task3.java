package exam;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dancers = Integer.parseInt(scan.nextLine());
        double points = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String place = scan.nextLine();

        double reward = 0;
       // double rewardAbroad = 0;
        double leftMoney = 0;

        switch (place) {
            case "Bulgaria":
                reward = dancers * points;
                if (season.equals("summer")) {
                    leftMoney = reward - reward * 0.05;
                } else {
                    leftMoney = reward - reward * 0.08;
                }
                break;
            case "Abroad":
                reward = dancers * points + (dancers * points*0.5);
                if (season.equals("summer")) {
                    leftMoney = reward - reward * 0.1;
                } else {
                    leftMoney = reward - reward * 0.15;
                }
                break;
        }



        double charity = leftMoney * 0.75;
        double finalSum = leftMoney - charity;

        double rewardPerDancer = finalSum / dancers;

        System.out.printf("Charity - %.2f%n", charity);
        System.out.printf("Money per dancer - %.2f", rewardPerDancer);


    }
}
