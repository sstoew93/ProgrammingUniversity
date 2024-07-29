package exam;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int students = Integer.parseInt(scan.nextLine());

        int topStudents = 0;
        int betweenFourAndFive = 0;
        int betweenThreeAndFour = 0;
        int fail = 0;
        double gradesSum = 0;



        for (int i = 1; i <= students; i++) {

            double grade = Double.parseDouble(scan.nextLine());

            gradesSum += grade;

            if (grade >= 5) {
                topStudents++;
            } else if (grade >= 4 && grade <= 4.99) {
                betweenFourAndFive++;
            } else if (grade >= 3 && grade <= 3.99) {
                betweenThreeAndFour++;
            } else {
                fail++;
            }

        }

        double topStudentsPercentage = topStudents * 1.0 / students * 100;
        double betweenFourAndFivePercentage = betweenFourAndFive * 1.0 / students * 100;
        double betweenThreeAndFourPercentage = betweenThreeAndFour * 1.0 / students * 100;
        double failPercentage = fail * 1.0 / students * 100;

        double averageGrade = gradesSum  / students;

        System.out.printf("Top students: %.2f%%%n",topStudentsPercentage);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n",betweenFourAndFivePercentage);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", betweenThreeAndFourPercentage);
        System.out.printf("Fail: %.2f%%%n", failPercentage);
        System.out.printf("Average: %.2f", averageGrade);

    }
}
