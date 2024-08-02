package Methods;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String start = scan.nextLine();
        String end = scan.nextLine();

        asciiPrint(start,end);

    }

    private static String asciiPrint (String start,String end) {

        if (start.charAt(0) > end.charAt(0)) {
            for (int i = end.charAt(0) + 1; i < start.charAt(0) ; i++) {

                System.out.printf("%c ", i);

            }
            return null;
        } else {

            for (int i = start.charAt(0) + 1; i < end.charAt(0); i++) {

                System.out.printf("%c ", i);

            }
        }
        return null;
    }
}
