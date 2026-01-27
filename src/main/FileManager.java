package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager implements FileSystemUtils {
    public static void CreateFile(Path path) {
        try {
            if (Files.exists(path)) {
                return;
            }

            Files.createFile(path);
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo");
        }
    }

    public static void writeFile(Path path, String text) {
        try {
            Files.writeString(path, text, StandardCharsets.UTF_8);

        } catch (Exception e) {
            System.out.println("Erro ao Escrever no arquivo");
        }
    }

    public static void AppendFile(Path path, String text) {
        try {
            Files.writeString(
                    path,
                    text,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

        } catch (Exception e) {
            System.out.println("Erro ao Escrever no arquivo");
        }
    }
}
