package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input data
        String[] inputData = scan.nextLine().split(",\\s+");
        int dimensions = Integer.parseInt(inputData[0]);
        String pattern = inputData[1];

        //Initialize matrix
        int [][] matrix = new int[dimensions][dimensions];

        //Check pattern
        if ("A".equals(pattern)) {
            //Create method to fill pattern A
            fillMatrixA(dimensions, matrix);
        } else {
            //Create method to fill pattern B
            fillMatrixB(dimensions,matrix);
        }

        //Print result
        printingMatrix(matrix);

    }

    private static void printingMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixB(int dimensions,int[][] matrix) {
        int start = 1;

        for (int col = 0; col < dimensions ; col++) {

            if ((col + 1) % 2 == 1) {
                for (int row = 0; row < dimensions ; row++) {
                    matrix[row][col] = start;
                    start++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][col] = start;
                    start++;
                }
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixA(int dimensions, int[][] matrix) {
        int start = 1;

        for (int col = 0; col < dimensions ; col++) {
            for (int row = 0; row < dimensions ; row++) {
                matrix[row][col] = start;
                start++;
            }
        }
        return matrix;
    }
}
