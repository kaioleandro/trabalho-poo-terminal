package main.command;

import main.DirectoryManager;
import main.PathManager;

public class CommandMkdir extends Command {
    @Override
    public String name() {
        return "mkdir";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("=== Uso incorreto de comando existente ===");
            System.out.println("Uso do comando: mkdir <nome do diretorio>");
            return;
        }

        DirectoryManager.createDirectory(PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(args[1])
        );
    }
}
