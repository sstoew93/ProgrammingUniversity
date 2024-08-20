package StreamsFilesDirectories;

import java.io.File;

public class FolderSiz {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\PC\\Documents\\GitHub\\JavaAdvanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        long size = 0;
        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (!file.isDirectory()) {
                        size += file.length();
                    }
                }
            }
        }
        System.out.printf("Folder size: %d", size);
    }
}
