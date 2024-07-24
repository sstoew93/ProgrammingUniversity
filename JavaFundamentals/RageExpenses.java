import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lostGames = Integer.parseInt(scan.nextLine());
        double headset = Double.parseDouble(scan.nextLine());
        double mouse = Double.parseDouble(scan.nextLine());
        double keyboard = Double.parseDouble(scan.nextLine());
        double display = Double.parseDouble(scan.nextLine());

        int counterHead = 0;
        int counterMouse = 0;
        int counterKeyboard = 0;
        int counterDisplay = 0;


        for (int lostGameCheck = 1; lostGameCheck <= lostGames ; lostGameCheck++) {
            if (lostGameCheck % 2 == 0) {
                counterHead++;
            }
            if (lostGameCheck % 3 == 0) {
                counterMouse++;
            }
            if (lostGameCheck % 6 == 0) {
                counterKeyboard++;
            }
            if (lostGameCheck % 12 == 0) {
                counterDisplay++;
            }

        }

        double sumPrice =counterDisplay*display+
                counterKeyboard*keyboard+
                counterHead*headset+
                counterMouse*mouse;
        System.out.printf("Rage expenses: %.2f lv.%n", sumPrice);


    }
}
