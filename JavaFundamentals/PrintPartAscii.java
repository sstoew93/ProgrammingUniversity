import java.util.Scanner;

public class PrintPartAscii {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());

        for (int code = start; code <= end ; code++) {

            System.out.print((char) code + " ");

        }

    }
}
