package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine().toLowerCase();

        System.out.println(countVowels(input));

    }

    private static int countVowels (String text) {

        int count = 0;

        for (int i = 0; i <= text.length() - 1 ; i++) {

            if (text.charAt(i) == 'a'
                    || text.charAt(i) == 'e'
                    || text.charAt(i) == 'i'
                    || text.charAt(i) == 'o'
                    || text.charAt(i) == 'u' ) {
                count++;
            }
        }

        return count;
    }
}
