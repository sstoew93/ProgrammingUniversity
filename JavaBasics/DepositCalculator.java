import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {

     Scanner scan = new Scanner(System.in);

        double deposit = Double.parseDouble(scan.nextLine());
        int time = Integer.parseInt(scan.nextLine());
        double interest = Double.parseDouble(scan.nextLine());
        double intrate = interest / 100;

        double total = deposit +  time * (( deposit * intrate ) / 12);

        System.out.println(total);

    }
}
