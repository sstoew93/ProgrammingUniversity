import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int floorsNum = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());

        for (int floor = floorsNum; floor >= 1 ; floor--) {
            for (int room = 0; room < rooms; room++) {

                if (floor == floorsNum) {
                    System.out.printf("L%s%s ",floor, room);
                } else if (floor % 2 == 0) {
                    System.out.printf("O%s%s ", floor, room);
                } else {
                    System.out.printf("A%s%s ", floor, room);
                }

            }

            System.out.println();

        }

    }
}
