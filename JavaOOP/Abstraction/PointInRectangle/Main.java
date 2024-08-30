package Abstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bottomLeftX = inputLine[0];
        int bottomLeftY = inputLine[1];
        int topRightX = inputLine[2];
        int topRightY = inputLine[3];

        int n = Integer.parseInt(scan.nextLine());

        Point bottomCoordinates = new Point(bottomLeftX, bottomLeftY);
        Point topCoordinates = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomCoordinates, topCoordinates);

        for (int test = 0; test < n; test++) {
            int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int xPoint = coordinates[0];
            int yPoint = coordinates[1];

            Point point = new Point(xPoint, yPoint);

            System.out.printf("%b%n", rectangle.contains(point));

        }
    }
}
