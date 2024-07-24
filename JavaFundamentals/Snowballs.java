import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        byte balls = Byte.parseByte(scan.nextLine());

        double maxValue = Integer.MIN_VALUE;

        int snowBallBig = 0;
        int snowTime = 0;
        int snowQuality = 0;

        for (int i = 1; i <= balls; i++) {

            short snowBallSnow = Short.parseShort(scan.nextLine());
            short snowBallTime = Short.parseShort(scan.nextLine());
            byte quality = Byte.parseByte(scan.nextLine());



            double value = Math.pow(snowBallSnow / snowBallTime , quality);

            if (value > maxValue) {
                maxValue = value;
                snowBallBig = snowBallSnow;
                snowTime = snowBallTime;
                snowQuality = quality;
            }

        }

        System.out.printf("%d : %d = %.0f (%d)", snowBallBig , snowTime, maxValue, snowQuality);

    }
}
