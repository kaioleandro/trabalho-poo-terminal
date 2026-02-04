package main.command;

import main.DirectoryManager;
import main.PathManager;

import java.nio.file.Path;
import java.util.Arrays;

public class CommandMkdir extends Command {
    @Override
    public String name() {
        return "mkdir";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("mkdir: falta operando");
            System.out.println("Tente 'mkdir --help' para mais informações.");
            return;
        }

        String spacedName = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        if (spacedName.charAt(0) == '\'' && spacedName.charAt(spacedName.length() - 1) == '\'') {
            DirectoryManager.createDirectory(PathManager.getInstance().getCurrentPath().resolve(Arrays.stream(rawInput.split("'")).toArray()[1].toString()));
        } else {
            for (int i = 1; i < args.length; i++) {
                DirectoryManager.createDirectory(PathManager.getInstance().getCurrentPath().resolve(args[i]));
            }
        }
    }
    @Override
    public String help() {
        return """
Comando: mkdir
Descrição: Cria um novo diretório.
Uso:
    mkdir <nome_do_diretorio>
""";
    }
}
