package Methods;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        while (!command.equals("END")) {

            System.out.println(reversedString(command));

            command = scan.nextLine();
        }

    }

    private static boolean reversedString (String text) {
        String reversed = "";

        for (int i = text.length() - 1; i >= 0 ; i--) {

            reversed += (text.charAt(i));

        }

        if (reversed.equals(text)) {
            return true;
        }
        return false;
    }
}
