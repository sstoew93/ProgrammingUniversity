package Lists;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scan.nextLine()
                        .split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {

            String[] commandParts = command.split(" ");
            String commandType = commandParts[0];
            int element = Integer.parseInt(commandParts[1]);
            if (commandType.equals("Delete")) {

                if(input.contains(element)) {
                    for (int i = 0; i <= input.size() - 1 ; i++) {
                        input.remove(Integer.valueOf(element));
                    }
                }

            } else {

                int index = Integer.parseInt(commandParts[2]);
                input.add(index, element);

            }


            command = scan.nextLine();
        }

        for (int output:input) {
            System.out.print(output + " ");
        }

    }
}
