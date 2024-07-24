import java.util.Scanner;

public class BonusScore {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int points = Integer.parseInt(scan.nextLine());
        double bonus = 0;

        if (points <= 100)
            bonus = 5;
        else if (points > 1000) {
            bonus = points * (10 / 100.0);
        } else {
            bonus = points * (20 / 100.0);
        }

        if (points % 2 == 0) {
            bonus = bonus + 1;
        } else if (points % 10 == 5) {
            bonus = bonus + 2;
        }

        double totalPoints = points + bonus;
        System.out.println(bonus);
        System.out.println(totalPoints);

        }
}
