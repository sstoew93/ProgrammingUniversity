package AssociativeArrays;
import java.util.*;
public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().toLowerCase().split(" ");

        LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();

        for (String word : input) {

            if (!resultMap.containsKey(word)) {
                resultMap.put(word, 1);
            } else {
                resultMap.put(word, resultMap.get(word) + 1);
            }

        }

        List<String> resultArr = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {

            if (entry.getValue() % 2 != 0) {
                resultArr.add(entry.getKey());
            }

        }

        System.out.println(String.join(", ", resultArr));

    }
}
