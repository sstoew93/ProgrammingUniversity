import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String day = scan.nextLine();

        switch (day) {
            case "Monday":
            case "Friday":
            case "Tuesday":
                System.out.println(12);
                break;
            case "Wednesday":
            case "Thursday":
                System.out.println(14);
                break;
            case "Saturday":
            case "Sunday":
                System.out.println(16);

        }

    }
}
