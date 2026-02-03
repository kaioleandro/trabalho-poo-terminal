package main.command;

import main.PathManager;

public class CommandPwd extends Command{
    @Override
    public String name() {
        return "pwd";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        String path = PathManager
                .getInstance()
                .getCurrentPath()
                .toString();

        int index = path.indexOf("/home/user");

        if (index == -1) {
            System.out.println(path);
            return;
        }

        System.out.println(path.substring(index));
    }
    public String help() {
        return """
Comando: pwd
Descrição: Exibe o diretório atual.
Uso:
    pwd
""";
    }
}

