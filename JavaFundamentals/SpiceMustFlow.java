import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startYield = Integer.parseInt(scan.nextLine());

        int spiceSum = 0;
        int days = 0;

        while (startYield >= 100) {

            int spices = startYield - 26;
            spiceSum += spices;
            days++;

            startYield-=10;

        }

        System.out.println(days);

        if (spiceSum >= 26) {
            spiceSum -= 26;
        }

        System.out.println(spiceSum);





    }
}
