package Abstraction.StudentSystem;

import java.util.HashMap;
import java.util.Map;


public class StudentSystem {
    private Map<String, Student> data;

    public StudentSystem() {
        this.data = new HashMap<>();
    }

    public void check(String[] input) {

        if (input[0].equals("Create")) {
            createStudent(input);
        }
        else if (input[0].equals("Show")) {
            String name = input[1];
            showStudent(name);
        }
    }

    private void showStudent(String name) {
        if (data.containsKey(name)) {
            Student student = data.get(name);

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s is %s years old.",student.getName(),student.getAge()));

            if (student.getGrade() >= 5.00) {
                sb.append(" Excellent student.");
            }
            else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                sb.append(" Average student.");
            }
            else {
                sb.append(" Very nice person.");
            }

            System.out.println(sb.toString());
        }
    }

    private void createStudent(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);

        Student student = new Student(name, age, grade);
        data.putIfAbsent(name,student);
    }
}
