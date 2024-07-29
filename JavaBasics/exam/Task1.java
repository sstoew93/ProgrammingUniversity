package exam;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int rollsPaper = Integer.parseInt(scan.nextLine());
        int rollsCloth = Integer.parseInt(scan.nextLine());
        double litersGlue = Double.parseDouble(scan.nextLine());
        int discount = Integer.parseInt(scan.nextLine());

        double paperPrice = rollsPaper * 5.80;
        double clothPrice = rollsCloth * 7.20;
        double gluePrice = litersGlue * 1.20;

        double allMaterialsPrice = paperPrice+clothPrice+gluePrice;

        double fullPrice = allMaterialsPrice - (allMaterialsPrice * discount / 100);


        System.out.printf("%.3f", fullPrice);


    }
}
