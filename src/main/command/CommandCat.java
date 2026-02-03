package main.command;

import main.FileManager;
import main.PathManager;

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
        if (args.length != 2) {
            System.out.println("cat: falta operando");
            System.out.println("Tente 'cat --help' para mais informações.");

            return;
        }

        FileManager.readFile(
                PathManager
                        .getInstance()
                        .getCurrentPath()
                        .resolve(args[1])
                )
                .forEach(System.out::println);
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
