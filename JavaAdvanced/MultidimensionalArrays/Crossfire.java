package MultidimensionalArrays;

import java.util.*;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Fill matrix
        int[][] matrix = fillMatrix(scan);

        // Reading input commands while input not equal
        String inputCommand = scan.nextLine();
        while (!"Nuke it from orbit".equals(inputCommand)) {

            String[] commands = inputCommand.split("\\s+");

            int rowCom = Integer.parseInt(commands[0]);
            int colCom = Integer.parseInt(commands[1]);
            int radiusCom = Integer.parseInt(commands[2]);

            // Method for logic of destroying elements in matrix
            destroyMatrix(matrix, rowCom, colCom, radiusCom);

            inputCommand = scan.nextLine();
        }

        // Printing final result
        printMatrix(matrix);
    }

    private static void destroyMatrix(int[][] matrix, int rowCom, int colCom, int radiusCom) {
        // Destroy in vertical
        for (int i = colCom - radiusCom; i <= colCom + radiusCom; i++) {
            if (i >= 0 && i < matrix[rowCom].length) {
                matrix[rowCom][i] = 0;
            }
        }


        // Destroy in horizontal
        for (int j = rowCom - radiusCom; j <= rowCom + radiusCom; j++) {
            if (j >= 0 && j < matrix.length) {
                matrix[j][colCom] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 0) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(Scanner scan) {
        int[] dimensions = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int fillNumber = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = fillNumber;
                fillNumber++;
            }
        }

        return matrix;
    }
}
