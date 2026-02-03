package main.command;

import main.FileManager;
import main.PathManager;

import java.nio.file.Path;

public class CommandEcho extends Command {

    @Override
    public String name() {
        return "echo";
    }

    @Override
    protected void execute(String[] args, String rawInput) {
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        if (!rawInput.contains(">")) {
            System.out.println("echo: comando incorreto");
            System.out.println("Tente 'echo --help' para mais informações.");
            return;
        }

        boolean append = rawInput.contains(">>");
        String operator = append ? ">>" : ">";

        String[] parts = rawInput.split(operator);

        String text = parts[0].replaceFirst("echo", "").trim();
        String fileName = parts[1].trim();

        Path filePath = PathManager
                .getInstance()
                .getCurrentPath()
                .resolve(fileName);

        if (append) {
            FileManager.appendFile(filePath, text + System.lineSeparator());
        } else {
            FileManager.writeFile(filePath, text + System.lineSeparator());
        }
    }
    public String help() {
        return """
Comando: echo
Descrição: Escreve texto em um arquivo.
Uso:
    echo "texto" > <arquivo>  -> reescreve o arquivo com o texto informado.
    echo "texto" >> <arquivo> -> adiciona o texto informado no arquivo.
""";
    }
}
