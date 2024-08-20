package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        int currentByte = fileStream.read();
        while (currentByte >= 0) {
            System.out.printf("%s ", Integer.toBinaryString(currentByte));
            currentByte = fileStream.read();
        }
        fileStream.close();
    }
}
