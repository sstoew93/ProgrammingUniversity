package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        long sum = 0;
        String read = reader.readLine();
        while (read != null) {
            char[] chars = read.toCharArray();
            for (char c : chars) {
                sum += c;
            }
            read = reader.readLine();
        }
        System.out.printf("%d%n", sum);
        reader.close();
    }
}