package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteThird {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt");
        Scanner scanner = new Scanner(fileInputStream);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        int count = 1;
        String line = scanner.nextLine();
        while (scanner.hasNextLine()) {
            if (count % 3 == 0) {
                writer.println(line);
            }
            count++;
            line = scanner.nextLine();
        }
        scanner.close();
        writer.close();
    }
}
