package StreamsFilesDirectories;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        if (folder.exists()) {
            if (folder.isDirectory()) {
                File[] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%s]%n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}
