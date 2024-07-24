import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());

        int sum = 0;

        do {
            sum = num*multiplier;
            System.out.printf("%d X %d = %d%n", num, multiplier, sum);
            multiplier++;
        } while (multiplier <= 10 );






    }
}
