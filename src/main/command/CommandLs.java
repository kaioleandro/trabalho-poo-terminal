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
    public void execute(String[] args) {
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
}
