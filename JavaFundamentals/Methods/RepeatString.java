package Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {

        text();

    }

    public static String text () {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int countRepeats = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= countRepeats; i++) {
            System.out.print(input);
        }
       return null;
    }

}
