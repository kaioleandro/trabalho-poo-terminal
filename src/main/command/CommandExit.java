package main.command;

public class CommandExit extends Command{
    @Override
    public String name() {
        return "exit";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        System.exit(0);
    }
    public String help() {
        return """
Comando: exit
Descrição: Encerra o programa.
Uso:
    exit
""";
    }
}

