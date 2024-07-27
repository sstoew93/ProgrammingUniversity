package AssociativeArrays;
import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int words = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, ArrayList<String>> synonymMap = new LinkedHashMap<>();

        for (int i = 0; i < words ; i++) {

            String word = scan.nextLine();
            String synonym = scan.nextLine();

            if (!synonymMap.containsKey(word)) {
                synonymMap.put(word, new ArrayList<>());
                synonymMap.get(word).add(synonym);
            } else {

                synonymMap.get(word).add(synonym);

            }

        }

        for (Map.Entry<String, ArrayList<String>> entry : synonymMap.entrySet()) {

            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));

        }

    }
}
