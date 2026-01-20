package main.command;

import main.PathManager;

public class CommandPwd extends Command{
    @Override
    public String name() {
        return "pwd";
    }

    @Override
    public void execute(String[] args) {
        String path = PathManager
                .getInstance()
                .getCurrentPath()
                .toString();

        System.out.println(
                path.substring(path.indexOf("/home/user"))
        );
    }
}

