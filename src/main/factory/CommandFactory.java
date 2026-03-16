package main.factory;

import main.command.Command;

import java.util.Map;

public interface CommandFactory {
    Map<String, Command> createCommands();
}
