package main.command;

import main.PathManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommandTouch extends Command {

    @Override
    public String name() {
        return "touch";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("=== Uso incorreto de comando existente ===");
            System.out.println("Uso do comando: touch <arquivo>");
            return;
        }

        Path filePath = PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(args[1]);

        try {
            if (Files.exists(filePath)) {
                System.out.println("Arquivo já existe");
                return;
            }

            Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo");
        }
    }
}
