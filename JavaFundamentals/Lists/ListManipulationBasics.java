package Lists;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {

            String[] commandArray = command.split(" ");
            String commandToApply = commandArray[0];

            if(commandToApply.equals("Add")) {

                int number = Integer.parseInt(commandArray[1]);
                numbers.add(number);

            } else if (commandToApply.equals("Remove")) {

                int number = Integer.parseInt(commandArray[1]);
                numbers.remove(Integer.valueOf(number));

            } else if (commandToApply.equals("RemoveAt")) {

                int index = Integer.parseInt(commandArray[1]);
                numbers.remove(index);

            } else if (commandToApply.equals("Insert")) {

                int number = Integer.parseInt(commandArray[1]);
                int index = Integer.parseInt(commandArray[2]);
                numbers.add(index, number);

            }

            command = scan.nextLine();
        }

        for (int number: numbers) {

            System.out.print(number + " ");

        }

    }
}
