import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());
        double profit = 0;
        switch (type) {
            case "Premiere":
                profit = rows * columns * 12;
                System.out.printf("%.2f%nleva", profit);
                break;
            case "Normal":
                profit = rows * columns * 7.5;
                System.out.printf("%.2f%nleva", profit);
                break;
            case "Discount":
                profit = rows * columns * 5;
                System.out.printf("%.2f leva", profit);
                break;
        }

    }
}
