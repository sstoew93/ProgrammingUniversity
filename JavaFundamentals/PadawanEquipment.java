import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double sabers = Double.parseDouble(scan.nextLine());
        double robes = Double.parseDouble(scan.nextLine());
        double belts = Double.parseDouble(scan.nextLine());

        /*if (belts >= 10) {
            belts = -1;
        }*/

        double sabersPrice = sabers * Math.ceil(students + (students * 0.1));
        double robesPrice = robes * students;
        double beltsPrice = belts * (students - students / 6);

        double fullPrice = sabersPrice+robesPrice+beltsPrice;

        if (budget >= fullPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", fullPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", fullPrice-budget);
        }


    }
}
