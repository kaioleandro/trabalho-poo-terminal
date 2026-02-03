package main.command;

import main.DirectoryManager;
import main.PathManager;

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
            return;
        }

        DirectoryManager.createDirectory(PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(args[1])
        );
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
