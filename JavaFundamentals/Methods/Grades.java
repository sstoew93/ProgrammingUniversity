package Methods;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {

        grade();

    }

    public static void grade() {

        Scanner scan = new Scanner(System.in);

        double grade = Double.parseDouble(scan.nextLine());

        if (grade >= 2 && grade <= 2.99) {
            System.out.println("Fail");
        } else if (grade >= 3 && grade <= 3.49) {
            System.out.println("Poor");
        } else if (grade >= 3.5 && grade <= 4.49) {
            System.out.println("Good");
        } else if (grade >= 4.5 && grade <= 5.49) {
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }

    }

}
