package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Declare Stack
        Deque<Integer> stack = new ArrayDeque<>();

        //Reading count of commands
        int commandCount = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < commandCount ; i++) {

            //Reading commands
            String[] command = scan.nextLine().split("\\s+");
            String commandType = command[0];

            //Implementation of logic
            if ("1".equals(commandType)) {
                int elementToPush = Integer.parseInt(command[1]);
                stack.push(elementToPush);
            } else if ("2".equals(commandType)) {
                stack.pop();
            } else if ("3".equals(commandType)) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
