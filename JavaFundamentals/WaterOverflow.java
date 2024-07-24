import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int capacity = 255;
        int sumLiters = 0;

        for (int i = 1; i <= n ; i++) {

            int litersIncome = Integer.parseInt(scan.nextLine());

            sumLiters += litersIncome;

            if (sumLiters > capacity) {
                System.out.println("Insufficient capacity!");
                sumLiters -= litersIncome;
            }

        }

        System.out.printf("%d",sumLiters);



    }
}
