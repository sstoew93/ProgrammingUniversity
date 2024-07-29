import java.util.Scanner;

public class GreaterNumber {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

            int number1 = Integer.parseInt(scan.nextLine());
            int number2 = Integer.parseInt(scan.nextLine());

            if (number1 > number2) {
                System.out.println(number1);
            } else {
                System.out.println(number2);
            }
    }
}


