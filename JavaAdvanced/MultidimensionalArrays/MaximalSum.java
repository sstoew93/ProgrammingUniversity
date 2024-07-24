package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading dimension from input
        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        //Initialize new matrix
        int [][] matrix = new int[rows][cols];

        //Create method to fill the input into matrix
        fillMatrix(scan,matrix);
        
        int[][] maxSumSquare = findMaxSumSquare(matrix);

        //Printing new matrix
        for (int row = 0; row < maxSumSquare.length; row++) {
            for (int col = 0; col < maxSumSquare[row].length; col++) {
                System.out.print(maxSumSquare[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] findMaxSumSquare(int[][] matrix) {
        //Initialize help variables
        int maxSum = Integer.MIN_VALUE;

        int [][] maxSumSquare = new int[3][3];

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = 0;

                int[][] currentSquare = new int[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        currentSquare[x][y] = matrix[row + x][col + y];
                        currentSum += currentSquare[x][y];
                    }
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumSquare = currentSquare;
                }
            }

        }
        System.out.printf("Sum = %d%n", maxSum);
        return maxSumSquare;
    }

    private static int[][] fillMatrix(Scanner scan, int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            int[] inputArr = Arrays.stream(scan.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = inputArr;
        }
        return matrix;
    }
}
