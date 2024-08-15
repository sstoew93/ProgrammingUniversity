package Abstraction.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String[] input = scanner.nextLine().split(" ");
        while (!"Exit".equals(input[0])) {
            studentSystem.check(input);

            input = scanner.nextLine().split(" ");
        }
    }
}
