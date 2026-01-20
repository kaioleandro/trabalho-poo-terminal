package main.command;

import main.PathManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommandRm extends Command {

    @Override
    public String name() {
        return "rm";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("=== Uso incorreto de comando existente ===");
            System.out.println("Uso do comando: rm <arquivo/diretorio>");
            return;
        }

        Path filePath = PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(args[1]);

        try {
            if (!Files.exists(filePath)) {
                System.out.println("Arquivo ou diretório não encontrado");
                return;
            }

            Files.delete(filePath);
        } catch (IOException e) {
            System.out.println("Erro ao remover - O diretório não está vazio");
        }
    }
}
