package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading dimensions from input
        int dimensions = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[dimensions][];

        //Create method to fill matrix
        fillMatrix(scan,dimensions,matrix);

        //Create method to sum numbers from diagonals
        int sumFirst = sumFirstDiagonal(matrix);
        int sumSecond = sumSecondDiagonal(matrix);

        //Find the difference between both diagonals
        System.out.println(Math.abs(sumFirst-sumSecond));
    }

    private static int sumSecondDiagonal(int[][] matrix) {
        int sumSecond = 0;
        for (int row = matrix.length - 1, col = 0; row >= 0; row--, col++) {
            sumSecond += matrix[row][col];
        }
        return  sumSecond;
    }

    private static int sumFirstDiagonal(int[][] matrix) {
        int sumFirst = 0;
        for (int row = 0, col = 0; row < matrix.length; row++, col++) {
            sumFirst += matrix[row][col];
        }
        return sumFirst;
    }

    private static int[][] fillMatrix(Scanner scan,int dimensions,int[][] matrix) {
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
