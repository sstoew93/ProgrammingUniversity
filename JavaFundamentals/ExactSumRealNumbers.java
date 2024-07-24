import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < n; i++) {
            BigDecimal num = new BigDecimal(scan.nextLine());
            sum = sum.add(num);
        }

        System.out.println(sum);

    }
}
