package Lists;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scan.nextLine()
                        .split(" "))
                        .collect(Collectors.toList());

        String operations = scan.nextLine();

        while (!operations.equals("End")) {

            String[] operationsElements = operations.split("\\s+");
            String operation = operationsElements[0];

            switch (operation) {
                case "Add":

                    String numberToAdd = operationsElements[1];
                    numbers.add(numberToAdd);

                    break;
                case "Insert":

                    String numberToInsert = operationsElements[1];
                    int indexToInsert = Integer.parseInt(operationsElements[2]);

                    if (indexToInsert > numbers.size() || indexToInsert < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(indexToInsert, numberToInsert);
                    }

                    break;
                case "Remove":

                    int indexToRemove = Integer.parseInt(operationsElements[1]);

                    if (indexToRemove > numbers.size() || indexToRemove < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(indexToRemove);
                    }

                    break;
                case "Shift":
                    String position = operationsElements[1];
                    int count = Integer.parseInt(operationsElements[2]);
                    if (position.equals("left")) {

                        for (int i = 1; i <= count ; i++) {
                            String elementToShift = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(elementToShift);
                        }

                    } else {

                        for (int i = 1; i <= count ; i++) {
                            String elementToShift = numbers.get(numbers.size() - 1);
                            numbers.remove(numbers.size() - 1);
                            numbers.add(0, elementToShift);
                        }

                    }

                    break;
            }


            operations = scan.nextLine();
        }

        for (String number:numbers) {
            System.out.print(number + " ");
        }

    }


}
