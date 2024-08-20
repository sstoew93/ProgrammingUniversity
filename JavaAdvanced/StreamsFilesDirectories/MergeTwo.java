package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MergeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = Files.newBufferedReader(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        BufferedReader reader2 = Files.newBufferedReader(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
        BufferedWriter writer = Files.newBufferedWriter(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo2.txt"));
        String line = reader1.readLine();
        while (line != null) {
            writer.write(String.format("%s%n", line));
            line = reader1.readLine();
        }
        line = reader2.readLine();
        while (line != null) {
            writer.write(String.format("%s%n", line));
            line = reader2.readLine();
        }
        reader1.close();
        reader2.close();
        writer.close();
    }
}