import java.util.Scanner;

public class TriangleNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (int row = 1; row <= num ; row++) {

            for (int count = 1; count <= row ; count++) {
                System.out.print(row + " ");
            }
            System.out.println();

        }

    }
}
