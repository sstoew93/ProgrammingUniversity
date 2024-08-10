package SetsAndMaps;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read count of students
        int studentCount = Integer.parseInt(scan.nextLine());

        //Initialize map
        Map<String, List<Double>> data = new TreeMap<>();

        for (int student = 0; student < studentCount; student++) {

            String studentName = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine()
                    .split("\\s+")).mapToDouble(Double::parseDouble)
                            .toArray();

            data.putIfAbsent(studentName, new ArrayList<>());

            //Fill grades of student
            for (int i = 0; i < grades.length; i++) {
                double grade = grades[i];
                data.get(studentName).add(grade);
            }
        }

        //Printing results
        for (Map.Entry<String, List<Double>> student : data.entrySet()) {
            double sum = 0;
            for (Double grade : student.getValue()) {
                sum += grade;
            }

            Double average = sum / student.getValue().size();

            System.out.printf("%s is graduated with %s%n", student.getKey(), average);
        }
    }
}
