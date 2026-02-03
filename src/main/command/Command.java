package main.command;

public abstract class Command {

    public abstract String name();

    public final void execute(String input) {
        String[] args = input.trim().split("\\s+");
        execute(args, input);
    }

    protected abstract void execute(String[] args, String rawInput);
}
