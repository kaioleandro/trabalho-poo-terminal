package main.command;

import main.PathManager;

public class CommandPwd extends Command{
    @Override
    public String name() {
        return "pwd";
    }

    @Override
    public void execute(String[] args, String rawInput) {
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
}

