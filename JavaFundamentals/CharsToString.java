import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char line1 = scan.nextLine().charAt(0);
        char line2 = scan.nextLine().charAt(0);
        char line3 = scan.nextLine().charAt(0);

        System.out.printf("%c%c%c",line1,line2,line3);


    }
}
