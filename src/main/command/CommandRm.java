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
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("rm: falta operando");
            System.out.println("Tente 'rm --help' para mais informações.");
            return;
        }

        Path filePath = PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(args[1]);

        FileSystemUtils.DeleteFilesAndDiretories(filePath);
    }
    public String help() {
        return """
Comando: rm
Descrição: Remove um arquivo ou diretório.
Uso:
    rm <arquivo/diretório>
""";
    }
}
