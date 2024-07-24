package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Sum2x2Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading the dimensions from nextLine
        int[] dimensions = Arrays.stream(scan.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt).
                toArray();

        //Declare dimensions of matrix
        int rows = dimensions[0];
        int cols = dimensions[1];

        //Fill matrix with method
        int[][] matrix = readMatrix(scan, rows, cols);

        //Helping variables
        int sum = 0;
        int biggestSum = Integer.MIN_VALUE;
        int [][] biggestMatrix = new int[2][2];

        //Implement logic of finding sub matrix with the biggest sum of elements
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                //Calculating sums
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > biggestSum) {
                    biggestSum = sum;
                    biggestMatrix[0] = new int[] {matrix[row][col], matrix[row][col + 1]};
                    biggestMatrix[1] = new int[] {matrix[row + 1][col], matrix[row+1][col + 1]};
                }

            }
        }

        //Creating method to return biggestMatrix
        printSubMatrix(biggestMatrix);

        //Printing sum of SubMatrix
        System.out.println(biggestSum);

    }

    private static void printSubMatrix(int[][] biggestMatrix) {
        //Using for loop to print all elements of sub matrix
        for (int row = 0; row < biggestMatrix.length; row++) {
            for (int col = 0; col < biggestMatrix[row].length; col++) {
                System.out.print(biggestMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scan,int rows,int cols) {
        //Declare matrix
        int[][] matrix = new int[rows][cols];

        //Fill matrix via for loop
        for (int row = 0; row < rows; row++) {
            int[] matrixArr = Arrays.stream(scan.nextLine()
                    .split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = matrixArr;
        }
        return matrix;
    }
}
