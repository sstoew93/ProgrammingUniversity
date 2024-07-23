package AssociativeArrays;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, List<Double>> studentsGrade = new LinkedHashMap<>();
        LinkedHashMap<String,Double> averageStudents = new LinkedHashMap<>();

        for (int i = 1; i <= studentsCount ; i++) {

            String student = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            if (!studentsGrade.containsKey(student)) {

                studentsGrade.put(student,new ArrayList<>());
                studentsGrade.get(student).add(grade);

            } else {

                studentsGrade.get(student).add(grade);

            }


        }

        for (Map.Entry<String, List<Double>> entry : studentsGrade.entrySet()) {

            double sumGrades = 0;
            List<Double> grades = entry.getValue();

            for (double grade : grades) {
                sumGrades += grade;
            }

            if (sumGrades / grades.size() >= 4.5) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), sumGrades / grades.size());
            }

        }

    }
}
