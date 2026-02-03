package main.command;

import main.FileManager;
import main.PathManager;

import java.util.List;

public class CommandHistory extends Command {
    @Override
    public String name() {
        return "history";
    }

    @Override
    public void execute(String[] args, String rawInput) {
       List<String> commands = FileManager.readFile(PathManager.getInstance().getFileHistoryPath());
       for (int i = 0; i < commands.size() - 1; i++ ){
           System.out.println((i + 1) + " " + commands.get(i));
       }
    }
}
