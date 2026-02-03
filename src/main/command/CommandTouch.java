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
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("touch: falta o operando arquivo");
            System.out.println("Tente 'touch --help' para mais informações.");
            return;
        }

        Path filePath = PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(args[1]);

        FileManager.CreateFile(filePath);

    }
    public String help() {
        return """
Comando: touch
Descrição: Cria um novo arquivo vazio.
Uso:
    touch <arquivo>
""";
    }
}
