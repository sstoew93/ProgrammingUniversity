package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            char currentChar = input.charAt(i);

            if ('(' == currentChar) {

                stack.push(String.valueOf(i));

            } else if (')' == currentChar) {

                int startIdx = Integer.parseInt(stack.pop());
                String match = input.substring(startIdx, i + 1);
                System.out.println(match);

            }

        }


    }
}
