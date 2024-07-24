import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int countValid = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {

                    int sum = i+j+k;
                    if (sum == n) {
                        countValid++;
                    }

                }
            }
        }
        System.out.println(countValid);


    }
}
