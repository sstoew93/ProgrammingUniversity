package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initialize list and fill with stream
        List<String> collect = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        //Initialize Consumer to print with
        Consumer<String> printList = s -> System.out.println(s);

        //Call Consumer to print
        for (String element : collect) {
            printList.accept(element);
        }
    }
}
