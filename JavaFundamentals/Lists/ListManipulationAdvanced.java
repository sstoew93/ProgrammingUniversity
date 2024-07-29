package Lists;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .toList();

        String command = scan.nextLine();

        while (!command.equals("end")) {

            if (command.contains("Contains")) {

                String[] numberFromArray = command.split(" ");
                int value = Integer.parseInt(numberFromArray[1]);

                    if (numbers.contains(value)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }

            } else if (command.contains("even")) {

                for (int number:numbers) {
                    if (number % 2 == 0) {
                            System.out.print(number + " ");
                    }
                }
                System.out.println();

            } else if (command.contains("odd")) {

                for (int number:numbers) {
                    if (number % 2 != 0) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();

            } else if (command.contains("sum")) {
                int sum = 0;

                for (int number:numbers) {
                    sum += number;
                }
                System.out.println(sum);

            } else if (command.contains("Filter")) {

                String[] filterCommand = command.split(" ");
                String condition = filterCommand[1];
                int number = Integer.parseInt(filterCommand[2]);

                switch (condition) {
                    case "<":
                        for (int numberFromList:numbers) {
                            if (numberFromList < number) {
                                System.out.print(numberFromList + " ");
                            }
                        }
                        break;
                    case ">":
                        for (int numberFromList:numbers) {
                            if (numberFromList > number) {
                                System.out.print(numberFromList + " ");
                            }
                        }
                        break;
                    case ">=":
                        for (int numberFromList:numbers) {
                            if (numberFromList >= number) {
                                System.out.print(numberFromList + " ");
                            }
                        }
                        break;
                    case "<=":
                        for (int numberFromList:numbers) {
                            if (numberFromList <= number) {
                                System.out.print(numberFromList + " ");
                            }
                        }
                        break;
                }
                System.out.println();

            }
            command = scan.nextLine();
        }
    }
}
