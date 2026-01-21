package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface FileSystemUtils {
    static void DeleteFilesAndDiretories(Path path) {
        try {
            if (!Files.exists(path)) {
                System.out.println("Arquivo ou diretório não encontrado");
                return;
            }

            Files.delete(path);
        } catch (IOException e) {
            System.out.println("Erro ao remover - O diretório não está vazio");
        }
    }
}
