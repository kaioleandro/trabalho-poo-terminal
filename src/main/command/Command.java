package main.command;

public abstract class Command {
    public abstract String name();

    public abstract void execute(String[] args);
}

