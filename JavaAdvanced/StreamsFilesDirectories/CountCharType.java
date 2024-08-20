package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountCharType {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        BufferedWriter writer = Files.newBufferedWriter(Path.of("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input4.txt"));
        int vowels = 0;
        int otherSymbols = 0;
        int punctuation = 0;
        String line = reader.readLine();
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                    vowels++;
                } else if (symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?') {
                    punctuation++;
                } else if (symbol != ' ') {
                    otherSymbols++;
                }
            }
            line = reader.readLine();
        }
        String vowelsPrint = String.format("Vowels: %d%n", vowels);
        String otherSymbolsPrint = String.format("Other symbols: %d%n", otherSymbols);
        String punctuationPrint = String.format("Punctuation: %d%n", punctuation);
        writer.write(vowelsPrint);
        writer.write(otherSymbolsPrint);
        writer.write(punctuationPrint);
        reader.close();
        writer.close();
    }
}
