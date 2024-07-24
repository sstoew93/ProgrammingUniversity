package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int decimalInput = Integer.parseInt(scan.nextLine());

        Deque<Integer> stackBinary = new ArrayDeque<>();

        if (decimalInput == 0) {
            System.out.println(0);
            return;
        }

        while (decimalInput != 0) {

            stackBinary.push(decimalInput % 2);
            decimalInput = decimalInput / 2;

        }

        while (!stackBinary.isEmpty()) {
            System.out.print(stackBinary.pop());
        }

    }
}
