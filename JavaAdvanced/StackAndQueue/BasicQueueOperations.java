package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading input
        String[] nsx = scan.nextLine().split("\\s+");
        String[] numbers = scan.nextLine().split("\\s+");

        //Declare n,s,x
        int offerElements = Integer.parseInt(nsx[0]);
        int pollElements = Integer.parseInt(nsx[1]);
        int isPresent = Integer.parseInt(nsx[2]);

        //Declare queue
        Deque<Integer> queue = new ArrayDeque<>();

        //Fill the queue
        for (int i = 0; i < offerElements; i++) {
            queue.offer(Integer.valueOf(numbers[i]));
        }
        
        //Dequeue 
        for (int i = 1; i <= pollElements; i++) {
            queue.poll();
        }
        
        //Check if element is present in queue or print min element(print '0' if stack isEmpty)
        if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            if (queue.contains(isPresent)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
