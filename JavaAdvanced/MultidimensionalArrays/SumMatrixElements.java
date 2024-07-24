package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Create method to fill matrix
        int[][] matrix = readMatrix(scan);

        //Create method that print result of sum of all elements in matrix
        printSum(matrix);

    }

    private static void printSum(int[][] matrix) {

        int sum = 0;
        //Use for loop to sum all elements in matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                sum = sum + matrix[row][col];

            }
        }
        //Printing sum
        System.out.println(sum);
    }

    private static int[][] readMatrix(Scanner scan) {
        int[] dimensions = Arrays.stream(scan.nextLine()
                .split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        //Declare rows and cols dimensions
        int rows = dimensions[0];
        int cols = dimensions[1];

        //Declare new matrix
        int[][] matrix = new int[rows][cols];

        //Fill matrix logic
        for (int row = 0; row < rows; row++) {
            int[] rowArr = Arrays.stream(scan.nextLine()
                    .split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowArr;
        }
        //Printing rows and cols count
        System.out.println(rows);
        System.out.println(cols);

        //Return matrix in main method
        return matrix;
    }
}
