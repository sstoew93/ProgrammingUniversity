package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading dimensions from input
        int dimensions = Integer.parseInt(scan.nextLine());
        int [][] matrix = new int[dimensions][];

        //Create method to read dimensions and fill matrix from input
        readMatrix(scan,dimensions,matrix);

        //Read wrong value indexes
        String[] indexes = scan.nextLine().split("\\s+");
        int rowWrong = Integer.parseInt(indexes[0]);
        int colWrong = Integer.parseInt(indexes[1]);

        //Reading wrong value indexation and implement logic of replace
        replaceWrong(matrix,rowWrong,colWrong);

        //Printing matrix after replacement
        printMatrixAfterReplace(matrix);
    }

    private static void printMatrixAfterReplace(int[][] matrix) {
        //Printing matrix logic
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void replaceWrong(int[][] matrix, int rowWrong, int colWrong) {
        //Implement Logic of replacing
        int elementToReplace = matrix[rowWrong][colWrong];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                //Check if current element is equal to replacement
                if (elementToReplace == matrix[row][col]) {
                    int sum = 0;

                    // Left element
                    if (col > 0 && matrix[row][col - 1] != elementToReplace) {
                        sum += matrix[row][col - 1];
                    }
                    // Right element
                    if (col < matrix[row].length - 1 && matrix[row][col + 1] != elementToReplace) {
                        sum += matrix[row][col + 1];
                    }
                    // Down element
                    if (row < matrix.length - 1 && matrix[row + 1][col] != elementToReplace) {
                        sum += matrix[row + 1][col];
                    }
                    // Upper element
                    if (row > 0 && matrix[row - 1][col] != elementToReplace) {
                        sum += matrix[row - 1][col];
                    }

                    // Replace the element with the sum
                    matrix[row][col] = sum;
                }
            }
        }
    }

    private static int[][] readMatrix(Scanner scan,int dimensions,int [][] matrix) {
        //Fill matrix from input
        for (int row = 0; row < dimensions; row++) {
            int[] input = Arrays.stream(scan.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = input;
        }
        return matrix;
    }


}
