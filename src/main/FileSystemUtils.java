package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface FileSystemUtils {
    static void DeleteFilesAndDiretories(Path path) {
        try {
            if (!Files.exists(path)) {
                System.out.println("rm: não foi possível remover '"+path.getFileName()+"': Arquivo ou diretório inexistente");
                return;
            }

            Files.delete(path);
        } catch (IOException e) {
            System.out.println("rm: não foi possível remover '"+path.getFileName()+"/': Diretório não está vazio");
            // usando uma frase fictícia para satisfazer o enunciado do professor, onde rm também apaga diretórios desde que estejam vazios.
        }
    }
}
