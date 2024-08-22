package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt");
        int currentByte = fileInputStream.read();
        while (currentByte >= 0) {
            char currentSymbol = (char) currentByte;
            if (currentSymbol != '.' && currentSymbol != ',' && currentSymbol != '!' && currentSymbol != '?') {
                fileOutputStream.write(currentSymbol);
            }
            currentByte = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
