package main;

import main.command.*;
import main.factory.CommandFactory;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private final Map<String, Command> mappedCommands;

    public CommandHandler(CommandFactory factory) {
        this.mappedCommands = factory.createCommands();
    }

    public void catchCommand(String input) {
        String[] args = input.trim().split("\\s+");
        Command command = mappedCommands.get(args[0]);

        if (command == null) {
            System.out.println("Comando inválido");
            return;
        }

        command.execute(input);
    }
}

