package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading dimensions input
        int [] dimensions = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        //Create method to fill matrix
        fillMatrix(scan,matrix);

        //Reading input commands
        String input = scan.nextLine();
        while (!"END".equals(input)) {

            String[] tokens = input.split("\\s+");

            if (tokens.length != 5) {
                System.out.println("Invalid input!");
            } else {

                String command = tokens[0];
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                if ("swap".equals(command)) {

                    if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0 || row1 > rows ||
                            row2 > rows || col1 > cols || col2 > cols) {
                        System.out.println("Invalid input!");
                    } else {
                        String firstElement = matrix[row1][col1];
                        String secondElement = matrix[row2][col2];

                        matrix[row1][col1] = secondElement;
                        matrix[row2][col2] = firstElement;

                        //Printing matrix after each operation
                        printMatrix(matrix);
                    }
                }
            }

            input = scan.nextLine();
        }
    }

    private static String[][] printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    private static String[][] fillMatrix(Scanner scan, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] inputArr = scan.nextLine().split("\\s+");

            matrix[row] = inputArr;
        }
        return matrix;
    }
}
