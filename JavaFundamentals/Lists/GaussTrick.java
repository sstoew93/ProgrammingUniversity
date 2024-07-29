package Lists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        if (numbers.size() % 2 != 0) {
            numbers.add(numbers.size() / 2, 0);
        }

        for (int i = 0; i < numbers.size(); i++) {

            int sum = numbers.get(i) + numbers.get(numbers.size() - 1);
            numbers.set(i, sum);
            numbers.remove(numbers.size() - 1);

        }

        for (int number : numbers) {

            System.out.print(new DecimalFormat("0.###").format(number) + " ");

        }


    }
}
