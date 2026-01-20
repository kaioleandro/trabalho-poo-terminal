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
        if (!args[1].isBlank())
            DirectoryManager.createDirectory(PathManager
                    .getInstance()
                    .getCurrentPath()
                    .resolve(args[1])
            );
    }
}
