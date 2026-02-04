package main.command;

import main.PathManager;

import java.nio.file.Path;
import java.util.Arrays;

public class CommandCd extends Command{
    @Override
    public String name() {
        return "cd";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("cd: falta operando");
            System.out.println("Tente 'cd --help' para mais informações.");
            return;
        }

        String spacedName = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        if (spacedName.charAt(0) == '\'' && spacedName.charAt(spacedName.length() - 1) == '\'') {
            PathManager.getInstance().changeCurrentPath(Arrays.stream(rawInput.split("'")).toArray()[1].toString());
        } else {
            PathManager.getInstance().changeCurrentPath(args[1]);
        }
    }
    public String help() {
        return """
Comando: cd
Descrição: Navega entre diretórios.
Uso:
    cd <diretório> → acessa um subdiretório
    cd ..          → acessa o diretório pai
""";
    }
}
