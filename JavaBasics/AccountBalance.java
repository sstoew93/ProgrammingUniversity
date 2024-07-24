import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String data = scan.nextLine();
        double sum = 0;

        while (!data.equals("NoMoreMoney")) {

            double amount = Double.parseDouble(data);

            if (amount < 0) {
                System.out.println("Invalid operation!");
                break;
            }

            sum += amount;

            System.out.printf("Increase: %.2f%n" , amount);

            data = scan.nextLine();


        }

        System.out.printf("Total: %.2f" , sum);

    }
}
