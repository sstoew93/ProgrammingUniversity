package SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Read count of inputs
        int inputCount = Integer.parseInt(scan.nextLine());

        //Initialize map
        Map<String, List<Double>> grades = new TreeMap<>();

        //Fill map with data
        for (int student = 1; student <= inputCount; student++) {

            String[] data = scan.nextLine().split("\\s+");
            String studentName = data[0];
            double grade = Double.parseDouble(data[1]);

            grades.putIfAbsent(studentName, new ArrayList<>());

            grades.get(studentName).add(grade);

        }

        for (Map.Entry<String, List<Double>> entry : grades.entrySet()) {
            //Print student
            List<Double> gradesList = entry.getValue();
            System.out.printf(("%s -> "), entry.getKey());
            //Print grades
            double sum = 0;
            for (Double grade : gradesList) {
                sum += grade;
                System.out.printf("%.2f ", grade);
            }
            //Print avg grade
            System.out.printf("(avg: %.2f)%n", sum / gradesList.size());
        }
    }
}
