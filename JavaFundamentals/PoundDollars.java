import java.util.Scanner;

public class PoundDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pounds = Double.parseDouble(scan.nextLine());

        double dollars = pounds * 1.36;

        System.out.printf("%.3f", dollars);


    }
}
