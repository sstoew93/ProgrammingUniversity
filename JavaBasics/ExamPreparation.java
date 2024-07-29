import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int badGrade =  Integer.parseInt(scan.nextLine());


        double sumGrade = 0;
        int countProblems = 0;
        int bad = 0;
        String last = "";

        while ( bad < badGrade)  {
            String name = scan.nextLine();


            if (name.equals("Enough")) {
                System.out.printf("Average score: %.2f%n", sumGrade/countProblems);
                System.out.printf("Number of problems: %d%n", countProblems);
                System.out.printf("Last problem: %s", last);
                break;
            }

            int grade = Integer.parseInt(scan.nextLine());

            if (grade <= 4) {
                bad++;
            }

            if (bad >= badGrade) {
                System.out.printf("You need a break, %d poor grades.", bad);
            }

            countProblems++;
            sumGrade += grade;
            last = name;


        }

    }
}
