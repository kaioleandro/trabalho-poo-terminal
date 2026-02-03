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
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
       List<String> commands = FileManager.readFile(PathManager.getInstance().getFileHistoryPath());
       for (int i = 0; i < commands.size() - 1; i++ ){
           System.out.println((i + 1) + " " + commands.get(i));
       }
    }
    public String help() {
        return """
Comando: history
Descrição: Mostra o histórico de comandos digitados.
Uso:
    history
""";
    }
}
