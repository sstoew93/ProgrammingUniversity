package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();

        boolean isValidLength = between6And10chars(input);

        if (!isValidLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean isContainsChars = isContainsChars(input);

        if (!isContainsChars) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean isContainsDigits = isContainsDigits(input);

        if (!isContainsDigits) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength && isContainsDigits && isContainsChars) {
            System.out.println("Password is valid");
        }

    }
    
    private static boolean between6And10chars (String text) {
        if (text.length() <= 10 && text.length() >= 6) {
            return true;
        }
        return false;
    }

    private static boolean isContainsChars (String text) {

        for (char symbol:text.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isContainsDigits (String text) {
        int sumDigit = 0;

        for (char symbol: text.toCharArray()) {
            if (Character.isDigit(symbol)) {
                sumDigit++;
                if (sumDigit >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

}
