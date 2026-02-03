package main.command;

import main.FileSystemUtils;
import main.PathManager;

import java.nio.file.Path;

public class CommandRm extends Command {

    @Override
    public String name() {
        return "rm";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("rm: falta operando");
            return;
        }

        Path filePath = PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(args[1]);

        FileSystemUtils.DeleteFilesAndDiretories(filePath);
    }
}
