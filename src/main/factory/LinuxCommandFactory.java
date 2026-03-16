package main.factory;

import main.command.*;

import java.util.HashMap;
import java.util.Map;

public class LinuxCommandFactory  implements CommandFactory{

    @Override
    public Map<String, Command> createCommands() {
        Map<String, Command> commands = new HashMap<>();

        mapCommand(commands, new CommandPwd());
        mapCommand(commands, new CommandExit());
        mapCommand(commands, new CommandMkdir());
        mapCommand(commands, new CommandCd());
        mapCommand(commands, new CommandLs());
        mapCommand(commands, new CommandTouch());
        mapCommand(commands, new CommandRm());
        mapCommand(commands, new CommandHistory());
        mapCommand(commands, new CommandCat());
        mapCommand(commands, new CommandEcho());
        mapCommand(commands, new CommandHelp());

        return commands;
    }

    private void mapCommand(Map<String, Command> map ,Command command){
        map.put(command.name(), command);
    }
}
