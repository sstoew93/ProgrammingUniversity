import java.util.Scanner;

public class InchToCentimeters {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double a = Double.parseDouble(scan.next());
        double inch = a * 2.54;

        System.out.println(inch);

    }

}
