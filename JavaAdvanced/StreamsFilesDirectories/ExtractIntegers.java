package StreamsFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Scanner scanner = new Scanner(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt");
        PrintWriter writer = new PrintWriter(fileOutputStream);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }
        fileInputStream.close();
        writer.close();
    }
}