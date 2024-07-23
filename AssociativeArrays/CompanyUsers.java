package AssociativeArrays;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> Employees = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] info = input.split(" -> ");

            List<String> currentCompanyEmployees = Employees.get(info[0]);
            boolean containsId = currentCompanyEmployees != null && currentCompanyEmployees.contains(info[1]);

            if (!containsId) {
                Employees.putIfAbsent(info[0], new ArrayList<>());
                Employees.get(info[0]).add(info[1]);
            }


            input = scan.nextLine();
        }

        Employees.entrySet().stream()
                .forEach(c -> {
                    System.out.printf("%s%n", c.getKey());
                    c.getValue().forEach(e -> System.out.printf("-- %s%n", e));
                });


    }
}