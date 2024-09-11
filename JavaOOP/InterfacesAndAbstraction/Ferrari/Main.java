package InterfacesAndAbstraction.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String driverInput = scan.nextLine();

        Car ferrari = new Ferrari(driverInput);

        System.out.println(ferrari);
    }
}
