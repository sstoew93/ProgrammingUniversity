package Lists;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        int[] numberAndPower = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int number = numberAndPower[0];
        int power = numberAndPower[1];

        for (int index = 0; index <= numbers.size() - 1 ; index++) {

            if (number == numbers.get(index)) {

                //int minIndex = Math.max(0, index - power);
                //int maxIndex = Math.min(numbers.size() - 1, index + power);

                int minIndex = index - power;
                int maxIndex = index + power;

                if (minIndex < 0 )  {
                    minIndex = 0;
                } else if (maxIndex > numbers.size() - 1) {
                    maxIndex = numbers.size() - 1;
                }


                for (int i = maxIndex ; i >= minIndex  ; i--) {

                        numbers.remove(i);

                }

                index = -1;

            }

        }
        int sum = 0;
        for (int result:numbers) {
            sum += result;
        }

        System.out.println(sum);

    }
}
