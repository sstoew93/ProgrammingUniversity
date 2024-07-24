package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input[] = scan.nextLine().split("\\s+");
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= input.length - 1 ; i++) {
            stack.push(Integer.valueOf(input[i]));
        }


        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
