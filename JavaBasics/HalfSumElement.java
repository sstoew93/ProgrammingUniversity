import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int maxNum = Integer.MIN_VALUE;

        int sum =0;

        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if(num > maxNum) {
                maxNum = num;
            }

            sum += num;
        }

        int diff = Math.abs(maxNum- (sum - maxNum));
        sum = sum - maxNum;
        if (sum == maxNum) {
            System.out.printf("Yes%nSum = %d", maxNum);
        } else {
            System.out.printf("No%nDiff = %d", diff);
        }
    }
}
