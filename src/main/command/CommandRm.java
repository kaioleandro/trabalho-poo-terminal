package main.command;

import main.DirectoryManager;
import main.FileManager;
import main.FileSystemUtils;
import main.PathManager;

import java.nio.file.Path;
import java.util.Arrays;

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

        String spacedName = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        if (spacedName.charAt(0) == '\'' && spacedName.charAt(spacedName.length() - 1) == '\'') {
            Path filePath = PathManager.getInstance().getCurrentPath().resolve(Arrays.stream(rawInput.split("'")).toArray()[1].toString());
            FileSystemUtils.DeleteFilesAndDiretories(filePath);
        } else {
            for (int i = 1; i < args.length; i++) {
                FileSystemUtils.DeleteFilesAndDiretories(PathManager.getInstance().getCurrentPath().resolve(args[i]));
            }
        }
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
