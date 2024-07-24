import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int number = 1; number <= n; number++) {
            int sum = 0;
            int num = number;

            while (num > 0) {
                sum += num % 10;
                num = num / 10;

            }
            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", number);
            } else {
                System.out.printf("%d -> False%n", number);
            }
        }

    }
}
