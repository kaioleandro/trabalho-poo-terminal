package main.command;

public class CommandExit extends Command{
    @Override
    public String name() {
        return "exit";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        System.exit(0);
    }
}

