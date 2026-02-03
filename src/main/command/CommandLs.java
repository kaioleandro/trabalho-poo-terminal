package main.command;

import main.PathManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CommandLs extends Command {

    @Override
    public String name() {
        return "ls";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        Path currentPath = PathManager
                .getInstance()
                .getCurrentPath();

        try (Stream<Path> paths = Files.list(currentPath)) {
            paths.forEach(path ->
                    System.out.println(path.getFileName())
            );
        } catch (IOException e) {
            System.out.println("Erro ao listar diretório");
        }
    }
    public String help() {
        return """
Comando: ls
Descrição: Lista os arquivos e diretórios do diretório atual.
Uso:
    ls
""";
    }
}
