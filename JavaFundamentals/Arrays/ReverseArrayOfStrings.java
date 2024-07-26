package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");


        for (int i = 0; i < input.length / 2; i++) {

            String old = input[i];
            input[i] = input[input.length -1 - i];
            input[input.length - 1 - i] = old;


        }

        System.out.println(String.join(" ", input));


    }
}
