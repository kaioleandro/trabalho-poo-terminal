package main.command;

import main.PathManager;

public class CommandCd extends Command{
    @Override
    public String name() {
        return "cd";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("=== Uso incorreto de comando existente ===");
            System.out.println("Uso do comando: cd <nome de diretorio existente>");
            return;
        }

        PathManager.getInstance().changeCurrentPath(args[1]);
    }
}
