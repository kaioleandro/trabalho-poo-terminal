package main.command;

import main.PathManager;

public class CommandCd extends Command{
    @Override
    public String name() {
        return "cd";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length < 2 || args[1].isBlank()) {
            System.out.println("cd: falta operando");
            return;
        }

        PathManager.getInstance().changeCurrentPath(args[1]);
    }
}
