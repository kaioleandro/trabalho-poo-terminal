package main;

import main.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private final Map<String, Command> mappedCommands = new HashMap<>();

    public CommandHandler() {
        mapCommand(new CommandPwd());
        mapCommand(new CommandExit());
        mapCommand(new CommandMkdir());
        mapCommand(new CommandCd());
        mapCommand(new CommandLs());
        mapCommand(new CommandTouch());
        mapCommand(new CommandRm());
    }

    private void mapCommand(Command command) {
        mappedCommands.put(command.name(), command);
    }

    public void catchCommand(String input) {
        String[] args = input.trim().split("\\s+");

        Command command = mappedCommands.get(args[0]);

        if(command == null){
            System.out.println("Comando inválido");
            return;
        }

        command.execute(args);
    }
}

