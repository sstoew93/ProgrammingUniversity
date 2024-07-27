package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String,Integer> minerMap = new LinkedHashMap<>();

        while (true) {
            String type = scan.nextLine();
            if (type.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scan.nextLine());

            if (!minerMap.containsKey(type)) {
                minerMap.put(type, quantity);
            } else {
                int currentQuantity = minerMap.get(type);
                minerMap.put(type, currentQuantity + quantity);
            }

        }

        for (Map.Entry<String, Integer> entry : minerMap.entrySet()) {

            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());

        }


    }
}
