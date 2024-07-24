package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Deque<String> stack = new ArrayDeque<>();
        while (!"Home".equals(input)) {

            if (!"back".equals(input)) {
                stack.push(input);
                System.out.println(input);
            } else if (stack.size() <= 1) {
                System.out.println("no previous URLs");
            } else {
                stack.pop();
                System.out.println(stack.peek());
            }


            input = scan.nextLine();
        }


    }
}
