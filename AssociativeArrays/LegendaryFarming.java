package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        Map<String, Integer> junks = new LinkedHashMap<>();

        boolean isWin = false;

        while (!isWin) {
            String input = scan.nextLine();

            String [] inputData = input.split("\\s+");


            for (int index = 0; index <= inputData.length - 1; index += 2) {
                int quantity = Integer.parseInt(inputData[index]);
                String material = inputData[index + 1].toLowerCase();


                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {

                    int currentQuantity = materials.get(material);
                    materials.put(material, currentQuantity + quantity);
                } else {

                    if (junks.containsKey(material)) {
                        int currentQuantity = junks.get(material);
                        junks.put(material, currentQuantity + quantity);
                    } else {
                        junks.put(material, quantity);
                    }
                }


                if (materials.get("shards") >= 250) {

                    System.out.println("Shadowmourne obtained!");
                    materials.put("shards", materials.get("shards") - 250);
                    isWin = true;
                    break;
                } else if (materials.get("fragments") >= 250) {

                    System.out.println("Valanyr obtained!");
                    materials.put("fragments", materials.get("fragments") - 250);
                    isWin = true;
                    break;
                } else if (materials.get("motes") >= 250) {

                    System.out.println("Dragonwrath obtained!");
                    materials.put("motes", materials.get("motes") - 250);
                    isWin = true;
                    break;
                }
            }

            if (isWin) {
                break;
            }
        }


        materials.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        junks.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    }
}