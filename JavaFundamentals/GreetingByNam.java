import java.util.Scanner;

public class GreetingByNam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userID = scan.nextLine();

        System.out.println("Hello, " + userID + "!");
    }

}


