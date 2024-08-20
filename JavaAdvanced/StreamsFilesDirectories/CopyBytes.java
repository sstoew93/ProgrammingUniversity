package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");
        int currentByte = fileInputStream.read();
        while (currentByte >= 0) {
            if (currentByte == 32 || currentByte == 10) {
                fileOutputStream.write(currentByte);
            } else {
                String digit = String.valueOf(currentByte);
                for (int i = 0; i < digit.length(); i++) {
                    fileOutputStream.write(digit.charAt(i));
                }
            }
            currentByte = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}