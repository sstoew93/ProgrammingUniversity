import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;

        for (int i = 1; i <= n ; i++) {

            int userEntry = Integer.parseInt(scan.nextLine());

            if (userEntry < 200) {
                p1++;
            } else if (userEntry < 400) {
                p2++;
            } else if (userEntry < 600) {
                p3++;
            } else if (userEntry < 800) {
                p4++;
            } else {
                p5++;
            }

        }

        double sump1 = p1 * 1.0 / n * 100;
        double sump2 = p2 * 1.0 / n * 100;
        double sump3 = p3  *1.0 / n * 100;
        double sump4 = p4 *1.0 / n * 100;
        double sump5 = p5 * 1.0 / n * 100;

        System.out.printf("%.2f%%%n", sump1);
        System.out.printf("%.2f%%%n", sump2);
        System.out.printf("%.2f%%%n", sump3);
        System.out.printf("%.2f%%%n", sump4);
        System.out.printf("%.2f%%", sump5);
    }
}
