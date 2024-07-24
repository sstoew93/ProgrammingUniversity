import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int power = Integer.parseInt(scan.nextLine());
        int distance = Integer.parseInt(scan.nextLine());
        byte exhaust = Byte.parseByte(scan.nextLine());

        int countPoke = 0;
        int startPower = power;

        // n - power
        // m distance
        // y - exhaust

        while (power >= distance) {

            power = power - distance;
            countPoke++;

            if (power == startPower / 2 && exhaust != 0) {

                power = power / exhaust;

            }

        }
            System.out.println(power);
            System.out.println(countPoke);
    }
}
