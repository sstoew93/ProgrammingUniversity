package Methods;

import java.util.Scanner;

public class MiddleChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        middleChar(input);

    }

    private static void middleChar (String text) {

        if (text.length() % 2 != 0) {

            System.out.println(text.charAt(text.length() / 2));

        } else {

            System.out.println(text.charAt((text.length() / 2) - 1) + "" + text.charAt(text.length() / 2));

        }
    }

}
