package SetsAndMaps;

import java.util.*;

public class ContinentInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input count
        int inputCount = Integer.parseInt(scan.nextLine());

        //Initialize map for data
        Map<String, Map<String, List<String>>> dataMap = new LinkedHashMap<>();

        //Fill map with data
        for (int iter = 1; iter <= inputCount; iter++) {
            String input = scan.nextLine();

            String[] tokens = input.split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            dataMap.putIfAbsent(continent, new LinkedHashMap<>());
            dataMap.get(continent).putIfAbsent(country, new ArrayList<>());
            dataMap.get(continent).get(country).add(city);
        }

        //Printing output
        for (Map.Entry<String, Map<String, List<String>>> continent : dataMap.entrySet()) {
            System.out.printf("%s:%n", continent.getKey());

            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("  %s -> ", country.getKey());

                int count = 1;
                for (String city : country.getValue()) {
                    if (count == 1) {
                        System.out.print(city);
                    } else {
                        System.out.print(String.format(", %s", city));
                    }
                    count++;
                }
                System.out.println();
            }
        }
    }
}
