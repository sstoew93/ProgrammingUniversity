package MultidimensionalArrays;
import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Declare two matrix with method to compare is it equal
        int[][] matrix1 = readMatrix(scan);
        int[][] matrix2 = readMatrix(scan);

        //Declare a flag to return true/false
        boolean isEqual = compareMatrices(matrix1, matrix2);

        //Print
        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
    private static boolean compareMatrices(int[][] matrix1, int[][] matrix2) {
        //Check if both matrices have same length
        if(matrix1.length != matrix2.length) {
            return false;
        }

        //Comparing matrices
        for (int row = 0; row < matrix1.length; row++) {
            int[] array1 = matrix1[row];
            int[] array2 = matrix2[row];

            if(!Arrays.equals(array1, array2)) {
                return false;
            }
        }
        return true;
    }

    static int[][] readMatrix(Scanner scan) {
        //Method to fill the matrix
        int[] dimensions = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] array = Arrays.stream(scan.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = array;
        }
        return matrix;
    }
}
