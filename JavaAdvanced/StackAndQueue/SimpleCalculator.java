package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();

        for (int i = input.length - 1; i >= 0; i--) {
            String element = input[i];
            stack.push(element);
        }

        while (stack.size() > 1) {

            int num1 = Integer.parseInt(stack.pop());
            String expression = stack.pop();
            int num2 = Integer.parseInt(stack.pop());

            if ("+".equals(expression)) {
                stack.push(String.valueOf(num1 + num2));
            } else {
                stack.push(String.valueOf(num1 - num2));
            }

        }

        System.out.println(stack.peek());

    }
}
