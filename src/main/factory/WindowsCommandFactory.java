package main.factory;

import main.command.Command;
import main.command.linux.*;
import main.command.windows.CommandDir;

import java.util.HashMap;
import java.util.Map;

public class WindowsCommandFactory implements CommandFactory {
    @Override
    public Map<String, Command> createCommands() {
        Map<String, Command> commands = new HashMap<>();

        mapCommand(commands, new CommandDir());

        return commands;
    }

    private void mapCommand(Map<String, Command> map, Command command) {
        map.put(command.name(), command);
    }
}
