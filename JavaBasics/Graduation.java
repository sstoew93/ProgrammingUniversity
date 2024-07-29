import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        int level =0;
        int fail = 0;

        double sumGrade = 0;

        while (level <= 12) {
            double grade = Double.parseDouble(scan.nextLine());

            if (grade < 4) {
                fail++;
            }

            if (fail > 1) {
                System.out.printf("%s has been excluded at %s grade",name, level);
                break;
            }

            sumGrade += grade;
            level ++;


            if (level == 12) {
                System.out.printf("%s graduated. Average grade: %.2f", name, sumGrade / level);
                break;
            }
        }



    }
}
