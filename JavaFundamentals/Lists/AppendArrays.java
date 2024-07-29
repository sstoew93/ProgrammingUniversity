package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> arraysList = Arrays.stream(scan.nextLine()
                        .split("\\|"))
                        .collect(Collectors.toList());

        Collections.reverse(arraysList);

        System.out.println(arraysList.toString()
                .replace("[", "")
                .replace("]", "")
                .trim()
                .replaceAll(",", "")
                .replaceAll("\\s+", " "));

    }
}
