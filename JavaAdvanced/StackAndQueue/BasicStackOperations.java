package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading from console
        String[] nsx = scan.nextLine().split("\\s+");
        String[] numbers = scan.nextLine().split("\\s+");

        //Declaring stack
        Deque<Integer> numbersStack = new ArrayDeque<>();

        //Declaring expressions
        int pushElements = Integer.parseInt(nsx[0]);
        int popElements = Integer.parseInt(nsx[1]);
        int isPresent = Integer.parseInt(nsx[2]);

        //Push elements into stack
        for (int i = 0; i <= pushElements - 1; i++) {
            numbersStack.push(Integer.valueOf(numbers[i]));
        }

        //Pop elements from stack
        for (int i = 1; i <= popElements ; i++) {
            numbersStack.pop();
        }

        //Check if number is present or print smallest number in stack
        int smallestNumber = Integer.MAX_VALUE;

        if (numbersStack.contains(isPresent)) {
            System.out.println("true");
        } else if (numbersStack.isEmpty()) {
            System.out.println(0);
        } else {
            while (!numbersStack.isEmpty()) {
                int currentNumber = numbersStack.pop();

                if (currentNumber < smallestNumber) {
                    smallestNumber = currentNumber;
                }

            }
            System.out.println(smallestNumber);
        }

    }
}
