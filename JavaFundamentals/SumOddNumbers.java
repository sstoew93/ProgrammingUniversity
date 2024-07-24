import java.util.Scanner;

public class SumOddNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numbers = Integer.parseInt(scan.nextLine());

        int sum = 0;

        for (int i = 1; i <= numbers ; i++) {
            System.out.println(2*i-1);
            sum += 2*i-1;
        }

        System.out.printf("Sum: %d", sum);

    }
}
