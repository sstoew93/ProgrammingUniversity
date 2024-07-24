package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading dimensions
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        //Declare 2 methods to fill the matrices
        String[][] matrix1 = readMatrix(scan,rows,cols);
        String[][] matrix2 = readMatrix(scan,rows,cols);

        //Implement Logic
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                String elementM1 = matrix1[row][col];
                String elementM2 = matrix2[row][col];

                if (!elementM1.equals(elementM2)) {
                    System.out.print("* ");
                } else {
                    System.out.print(elementM1 + " ");
                }
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(Scanner scan,int rows,int cols) {

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] rowInput = scan.nextLine().split("\\s+");

            matrix[row] = rowInput;

        }
        return matrix;
    }
}
