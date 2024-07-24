package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fileName = scan.nextLine();

        Deque<String> queue = new ArrayDeque<>();

        while (!"print".equals(fileName)) {

            if ("cancel".equals(fileName)) {

                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else  {
                    System.out.println("Canceled " + queue.poll());
                }

            } else {
                queue.offer(fileName);
            }


           fileName = scan.nextLine();
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
