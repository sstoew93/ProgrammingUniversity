import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        for (int number = num1; number <= num2; number++) {

            int number1 = number / 100000;
            int number2 = number / 10000 % 10;
            int number3 = number / 1000 % 10;
            int number4 = number / 100 % 10;
            int number5 = number / 10 % 10;
            int number6 = number % 10;

            int odd = number1+number3+number5;
            int even = number2+number4+number6;

            if (odd == even) {
                System.out.printf("%d ", number);
            }

        }




    }
}
