package MultidimensionalArrays;

import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input
        String rotationInput = scan.nextLine();
        String input = scan.nextLine();

        //Create List<String to save data>
        Deque<String> matrixStack = new ArrayDeque<>();

        // Fill list with input
        while (!"END".equals(input)) {
            matrixStack.offer(input);

            input = scan.nextLine();
        }

        //Find the longest string in List
        String longest = "";
        for (String word:matrixStack) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        //Fill matrix from input
        int rows = matrixStack.size();
        int cols = longest.length();
        String [][] matrix = new String[rows][cols];
        fillMatrix(scan, matrix, matrixStack,rows);

        //Rotation
        int rotationAngle = 0;
        if (rotationInput.length() > 7) {
            rotationAngle = Integer.parseInt(rotationInput.substring(7).replaceAll("[^0-9]", "")) % 360;
        }
        String[][] rotatedMatrix = rotateMatrix(matrix, rotationAngle);

        //Printing matrix
        printMatrix(rotatedMatrix);
    }

    private static String[][] rotateMatrix(String[][] matrix, int rotationAngle) {

        //logic
        int rows = matrix.length;
        int cols = matrix[0].length;

        String[][] rotatedMatrix;
        if (rotationAngle == 90) {
            rotatedMatrix = new String[cols][rows];
        } else if (rotationAngle == 180) {
            rotatedMatrix = new String[rows][cols];
        } else if (rotationAngle == 270) {
            rotatedMatrix = new String[cols][rows];
        } else {
            rotatedMatrix = new String[rows][cols];
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Calculate the new position based on the rotation angle
                int newRow, newCol;
                if (rotationAngle == 90) {
                    newRow = col;
                    newCol = rows - 1 - row;
                } else if (rotationAngle == 180) {
                    newRow = rows - 1 - row;
                    newCol = cols - 1 - col;
                } else if (rotationAngle == 270) {
                    newRow = cols - 1 - col;
                    newCol = row;
                } else {
                    // No rotation
                    newRow = row;
                    newCol = col;
                }
                // Assign the value to the rotated matrix
                rotatedMatrix[newRow][newCol] = matrix[row][col];
            }
        }

        return rotatedMatrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static String[][] fillMatrix(Scanner scan, String[][] matrix, Deque<String> matrixStack,int rows) {
        //Fill matrix with whitespaces
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                matrix[row][col] = " ";
            }
        }

        //Fill matrix with elements of string input
        for (int row = 0; row < rows; row++) {
            char[] matrixArr = matrixStack.pop().toCharArray();

            for (int col = 0; col < matrixArr.length; col++) {
                matrix[row][col] = String.valueOf(matrixArr[col]);
            }
        }
        return matrix;
    }
}