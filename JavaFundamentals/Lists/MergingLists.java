package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> stringList1 = Arrays.stream(scan.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        List<String> stringList2 = Arrays.stream(scan.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();

        int currentIndex = 0;

        if (stringList1.size() < stringList2.size()) {

            for (int i = 0; i < stringList1.size(); i++) {
                result.add(stringList1.get(i));
                result.add(stringList2.get(i));
                currentIndex = i;
            }
            for (int j = currentIndex + 1; j < stringList2.size() ; j++) {
                result.add(stringList2.get(j));
            }

        } else {

            for (int i = 0; i < stringList2.size(); i++) {
                result.add(stringList1.get(i));
                result.add(stringList2.get(i));
                currentIndex = i;
            }
            for (int j = currentIndex + 1; j < stringList1.size() ; j++) {
                result.add(stringList1.get(j));
            }

        }

        for (String number:result) {

            System.out.print(number + " ");

        }

    }
}
