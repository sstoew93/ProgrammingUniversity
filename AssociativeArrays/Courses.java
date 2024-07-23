package AssociativeArrays;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, List<String>> coursesInfo = new LinkedHashMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }

            String[] commandParts = input.split(" : ");
            String course = commandParts[0];
            String studentName = commandParts[1];

            if (coursesInfo.containsKey(course)) {

                coursesInfo.get(course).add(studentName);

            } else {

                coursesInfo.put(course,new ArrayList<>());
                coursesInfo.get(course).add(studentName);

            }

        }

            coursesInfo.entrySet()
                    .forEach(entry -> {

                        System.out.println(entry.getKey() + ": " + entry.getValue().size());
                        entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));

                    });

    }
}
