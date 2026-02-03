package main.command;

import main.FileManager;
import main.PathManager;

import java.nio.file.Path;

public class CommandTouch extends Command {

    @Override
    public String name() {
        return "touch";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("=== Uso incorreto de comando existente ===");
            System.out.println("Uso do comando: touch <arquivo>");
            return;
        }

        Path filePath = PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(args[1]);

        FileManager.CreateFile(filePath);

    }
}
