import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());

        int piecesSum = width*height;

        String command = scan.nextLine();

        while ( !command.equals("STOP") ) {

            int pieces = Integer.parseInt(command);

            piecesSum -= pieces;

            if (piecesSum <= 0) {
                System.out.printf("No more cake left! You need %d pieces more.", Math.abs(piecesSum));
            break;
            }

            command = scan.nextLine();

        }

        if (piecesSum > 0) {
            System.out.printf("%d pieces are left.", piecesSum);
        }

    }
}
