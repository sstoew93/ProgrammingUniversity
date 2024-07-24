package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read dimensions of matrix and create
        int dimension = Integer.parseInt(scan.nextLine());
        int [][] matrix = new int[dimension][dimension];

        //Create method to fill matrix
        readMatrix(scan,dimension,matrix);

        //Create method to print diagonals
        printDiagonals(matrix,dimension);

    }

    private static void printDiagonals(int[][] matrix,int dimension) {
        //Printing first diagonal
        for (int row = 0,col=0; row < dimension; row++,col++) {
                System.out.print(matrix[row][col] + " ");
        }
        System.out.println();

        //Printing second diagonal
        for (int row = dimension - 1,col=0; row >= 0; row--,col++) {
            System.out.print(matrix[row][col] + " ");
        }
        System.out.println();
    }


    private static int[][] readMatrix(Scanner scan,int dimension, int [][] matrix) {
        //Fill matrix
        for (int row = 0; row < dimension; row++) {

            int[] input = Arrays.stream(scan.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = input;
        }
        return matrix;
    }
}
