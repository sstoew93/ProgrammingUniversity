import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        int sum = 0;
        int lastNum = 0;

        while (number > 0) {

            lastNum = number % 10;

             sum += lastNum;

             number = number / 10;

        }

        System.out.println(sum);


    }
}
