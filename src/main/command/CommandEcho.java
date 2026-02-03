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

        if (!rawInput.contains(">")) {
            System.out.println("Uso: echo 'texto' > arquivo.txt");
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
}
