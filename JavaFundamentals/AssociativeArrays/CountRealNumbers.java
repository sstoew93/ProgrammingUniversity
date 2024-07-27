package AssociativeArrays;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] numberArr = Arrays.stream(scan.nextLine()
                .split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        TreeMap<Double, Integer> numbersMap = new TreeMap<>();

        for (int i = 0; i < numberArr.length; i++) {

            double currentNumber = numberArr[i];

            if (!numbersMap.containsKey(currentNumber)) {

                numbersMap.put(currentNumber, 1);

            } else {
                int value = numbersMap.get(currentNumber);
                numbersMap.put(currentNumber, value + 1);

            }



        }

        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
