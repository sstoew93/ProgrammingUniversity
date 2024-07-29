package exam;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int focus = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();

        double earnedMoney = 0;
        String type = "";
        while (!command.equals("closed")) {

            switch (command) {
                case "haircut":
                    type = scan.nextLine();
                    if (type.equals("mens")) {
                        earnedMoney += 15;
                    } else if (type.equals("ladies")) {
                        earnedMoney+= 20;
                    } else {
                        earnedMoney += 10;
                    }
                    break;
                case "color":
                    String typeColor = scan.nextLine();
                    if (typeColor.equals("touch up")) {
                        earnedMoney += 20;
                    } else {
                        earnedMoney += 30;
                    }
                    break;
            }

            if (earnedMoney >= focus) {
                System.out.printf("You have reached your target for the day!%n");
                System.out.printf("Earned money: %.0flv.", earnedMoney);
                break;
            }

            command = scan.nextLine();
        }

            if (earnedMoney < focus) {
                System.out.printf("Target not reached! You need %.0flv. more.%n", focus - earnedMoney);
                System.out.printf("Earned money: %.0flv.", earnedMoney);
            }



    }
}





