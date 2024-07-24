package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damage = Double.parseDouble(scanner.nextLine());
        int playerHitPoints = 18500;
        double bossHitPoints = 3000000;
        int playerTurnClouds = 0;
        String killedBy = "";
        int[][] matrix = getMatrix();
        while (bossHitPoints > 0) {
            bossHitPoints -= damage;
            if (playerTurnClouds == 1) {
                playerHitPoints -= 3500;
                playerTurnClouds = 0;
            }
            if (playerHitPoints <= 0) {
                killedBy = "Plague Cloud";
                break;
            }
            if (bossHitPoints <= 0) {
                break;
            }
            String[] commandParts = scanner.nextLine().split("\\s+");
            String spell = commandParts[0];
            int xMatrix = Integer.parseInt(commandParts[1]);
            int yMatrix = Integer.parseInt(commandParts[2]);
            String position = checkPosition(matrix, xMatrix, yMatrix);
            if (position.equals("notSave")) {
                if (spell.equals("Cloud")) {
                    playerHitPoints -= 3500;
                    playerTurnClouds = 1;
                    if (playerHitPoints <= 0) {
                        killedBy = "Plague Cloud";
                        break;
                    }
                } else if (spell.equals("Eruption")) {
                    playerHitPoints -= 6000;
                    if (playerHitPoints <= 0) {
                        killedBy = "Eruption";
                        break;
                    }
                }
            }
        }
        printOutput(playerHitPoints, bossHitPoints, killedBy, matrix);
    }
    private static int[][] getMatrix() {
        int[][] matrix = new int[15][15];
        matrix[7][7] = 7;
        return matrix;
    }
    private static String checkPosition(int[][] matrix, int xMatrix, int yMatrix) {
        String position = "save";
        int x = 0;
        int y = 0;
        int newX;
        int newY;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 7) {
                    x = row;
                    y = col;
                }
            }
        }
        if (x == xMatrix && y == yMatrix) {
            position = "notSave";
            return position;
        } else if (isAttackIsInMatrix(x, y , xMatrix, yMatrix)){
            if (x - 1 < xMatrix - 1 && x - 1 < xMatrix + 1 && x - 1 < xMatrix && x - 1 >= 0) {
                newX = x - 1;
                newY = y;
            } else if (y + 1 > yMatrix + 1 && y + 1 > yMatrix - 1 && y + 1 > yMatrix && y + 1 <= 14) {
                newX = x;
                newY = y + 1;
            } else if (x + 1 > xMatrix + 1 && x + 1 > xMatrix - 1 && x + 1 > xMatrix && x + 1 <= 14) {
                newX = x + 1;
                newY = y;
            } else if (y - 1 < yMatrix - 1 && y - 1 < yMatrix + 1 && y - 1 < yMatrix && y - 1 >= 0) {
                newX = x;
                newY = y - 1;
            } else {
                position = "notSave";
                return position;
            }
            matrix[x][y] = 0;
            matrix[newX][newY] = 7;
        }
        return position;
    }
    private static boolean isAttackIsInMatrix(int x, int y, int xMatrix, int yMatrix) {
        if (x == xMatrix) {
            if (y == yMatrix || y == yMatrix - 1 || y == yMatrix +1) {
                return true;
            }
        } else if (x == xMatrix - 1) {
            if (y == yMatrix || y == yMatrix - 1 || y == yMatrix +1) {
                return true;
            }
        } else if (x == xMatrix + 1) {
            if (y == yMatrix || y == yMatrix - 1 || y == yMatrix +1) {
                return true;
            }
        }
        return false;
    }
    private static void printOutput(int playerHitPoints, double bossHitPoints, String killedBy, int[][] matrix) {
        int x = 0;
        int y = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 7) {
                    x = row;
                    y = col;
                }
            }
        }
        if (bossHitPoints <= 0) {
            System.out.printf("Heigan: Defeated!%n");
        } else {
            System.out.printf("Heigan: %.2f%n", bossHitPoints);
        }
        if (playerHitPoints <= 0) {
            System.out.printf("Player: Killed by %s%n", killedBy);
        } else {
            System.out.printf("Player: %d%n", playerHitPoints);
        }
        System.out.printf("Final position: %d, %d%n", x, y);
    }
}