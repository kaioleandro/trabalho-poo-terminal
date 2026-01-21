package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager implements FileSystemUtils {
    public static void CreateFile(Path path) {
        try {
            if (Files.exists(path)) {
                System.out.println("Arquivo já existe");
                return;
            }

            Files.createFile(path);
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo");
        }
    }
}
