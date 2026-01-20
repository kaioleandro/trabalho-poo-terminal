package main.command;

import main.PathManager;

public class CommandCd extends Command{
    @Override
    public String name() {
        return "cd";
    }

    @Override
    public void execute(String[] args) {
        PathManager.getInstance().changeCurrentPath(args[1]);
    }
}
