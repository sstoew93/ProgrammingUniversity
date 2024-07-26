package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();

        String command = scan.nextLine();


        while (!command.equals("end")) {

            if (command.contains("swap")) {

                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int firstIndex = numbers[index1];
                int secondIndex = numbers[index2];

                numbers[index1] = secondIndex;
                numbers[index2] = firstIndex;

            } else if (command.contains("multiply")) {

                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int sum = numbers[index1] * numbers[index2];

                numbers[index1] = sum;

            } else if (command.equals("decrease"))  {

                for (int i = 0; i <= numbers.length -1 ; i++) {

                    numbers[i]--;

                }

            }

            command = scan.nextLine();
        }

        System.out.println(Arrays.toString(numbers).replace("[", "").replace("]",""));

    }
}
