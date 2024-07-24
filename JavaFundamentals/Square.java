import java.util.Scanner;

public class Square {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int result = a*b;

        System.out.println(result);

    }
}