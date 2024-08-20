package StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathWrite = Paths.get("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");
        List<String> allLines = Files.readAllLines(pathRead);
        Collections.sort(allLines);
        Files.write(pathWrite, allLines);
    }
}