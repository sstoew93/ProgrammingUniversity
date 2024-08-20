package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        String line = reader.readLine();
        while (line != null) {
            char[] chars = line.toCharArray();
            long sum = 0;
            for (char c : chars) {
                sum += c;
            }
            System.out.printf("%d%n", sum);
            line = reader.readLine();
        }
        reader.close();
    }
}