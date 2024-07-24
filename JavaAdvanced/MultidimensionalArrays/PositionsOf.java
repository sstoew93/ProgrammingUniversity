package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [][] matrix = readMatrix(scan);
        int numberToFind = Integer.parseInt(scan.nextLine());

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if(numberToFind == matrix[row][col]) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }


        if (!isFound) {
            System.out.println("not found");
        }


    }

    private static int[][] readMatrix(Scanner scan) {

        int[] dimensions = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
                int [] input = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                matrix[row] = input;

        }
        return matrix;
    }


}
