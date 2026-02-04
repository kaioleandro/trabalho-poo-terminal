package main.command;

import main.FileManager;
import main.FileSystemUtils;
import main.PathManager;

import java.nio.file.Path;
import java.util.Arrays;

public class CommandCat extends Command {
    @Override
    public String name() {
        return "cat";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        if (args.length < 2) {
            System.out.println("cat: falta operando");
            System.out.println("Tente 'cat --help' para mais informações.");

            return;
        }
        String spacedName = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        if (spacedName.charAt(0) == '\'' && spacedName.charAt(spacedName.length() - 1) == '\'') {
            FileManager.readFile(
                            PathManager
                                    .getInstance()
                                    .getCurrentPath()
                                    .resolve(Arrays.stream(rawInput.split("'")).toArray()[1].toString())
                    )
                    .forEach(System.out::println);
        } else {
            FileManager.readFile(
                            PathManager
                                    .getInstance()
                                    .getCurrentPath()
                                    .resolve(args[1])
                    )
                    .forEach(System.out::println);
        }
    }
    public String help() {
        return """
Comando: cat
Descrição: Exibe o conteúdo de um arquivo.
Uso:
    cat <arquivo>
""";
    }
}
