package Abstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);
        String command = scanner.nextLine();

        while (!"Let the Force be with you".equals(command)) {

            int[] playerCoordinates = getCoordinates(command);
            int[] enemyCoordinates = getCoordinates(scanner.nextLine());

            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];
            int enemyRow = enemyCoordinates[0];
            int enemyCol = enemyCoordinates[1];

            moveEnemy(enemyRow, enemyCol, matrix);
            movePlayer(playerRow, playerCol, matrix);

            command = scanner.nextLine();
        }

        printResult();
    }

    private static long sum = 0;

    private static int[] getCoordinates(String command) {
        return Arrays.stream(command.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void printResult() {
        System.out.println(sum);
    }

    private static int[][] fillMatrix(Scanner scanner) {
        int[] dimensions = getCoordinates(scanner.nextLine());
        int x = dimensions[0];
        int y = dimensions[1];
        int[][] matrix = new int[x][y];
        int value = 0;
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                matrix[row][col] = value++;
            }
        }
        return matrix;
    }

    private static void moveEnemy(int row, int col, int[][] matrix) {
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[0].length) {
                matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    private static void movePlayer(int row, int col, int[][] matrix) {
        while (row >= 0 && col < matrix[0].length) {
            if (row < matrix.length && col >= 0) {
                sum += matrix[row][col];
            }
            row--;
            col++;
        }
    }
}