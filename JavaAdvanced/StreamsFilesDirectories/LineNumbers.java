package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        BufferedWriter writer = Files.newBufferedWriter(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers1.txt"));
        String line = reader.readLine();
        int counter = 1;
        while (line != null) {
            writer.write(counter + ". " + line);
            writer.write(System.lineSeparator());
            counter++;
            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}