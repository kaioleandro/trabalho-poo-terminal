package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryManager implements FileSystemUtils {

    public static void createDirectory(Path homeDirectory) {
        try {
            Files.createDirectories(homeDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
