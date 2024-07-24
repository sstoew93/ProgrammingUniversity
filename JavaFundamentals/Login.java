import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int position = username.length() - 1; position >= 0; position--) {
            char symbol = username.charAt(position);
            password += symbol;
        }


        int countWrongPass = 0;
        String pass = scanner.nextLine();

        while (!pass.equals(password)) {
            countWrongPass++;
            if (countWrongPass == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            pass = scanner.nextLine();
        }

        if (pass.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }

    }
}