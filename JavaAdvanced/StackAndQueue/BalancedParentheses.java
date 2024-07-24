package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input
        String input = scan.nextLine();
        String[] bracketsArr = input.split("");

        //Check if input is valid or print 'NO' and stop program
        if (input.length() % 2 != 0) {
            System.out.println("NO");
            return;
        }

        //Declare queue for open brackets
        Deque<String> openBracketsQueue = new ArrayDeque<>();

        //Declare a stack for closing brackets
        Deque<String> closingBracketsStack = new ArrayDeque<>();

        //Offer elements to queue of open brackets
        for (int i = 0; i < input.length() / 2; i++) {
            openBracketsQueue.offer(bracketsArr[i]);
        }

        //Push elements to stack of closing brackets
        for (int i = input.length() / 2; i < input.length(); i++) {
            closingBracketsStack.push(bracketsArr[i]);
        }

        //Declare boolean flag to check if its balanced or not
        boolean isBalanced = false;

        //Implement logic to check if parentheses is balanced
        while (!openBracketsQueue.isEmpty()) {
            //Declare brackets
            String openBracket = openBracketsQueue.poll();
            String closingBracket = closingBracketsStack.pop();

            if (openBracket.equals("{") && closingBracket.equals("}")) {
                isBalanced = true;
            } else if (openBracket.equals("[") && closingBracket.equals("]")) {
                isBalanced = true;
            } else if (openBracket.equals("(") && closingBracket.equals(")")) {
                isBalanced = true;
            } else {
                isBalanced = false;
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
