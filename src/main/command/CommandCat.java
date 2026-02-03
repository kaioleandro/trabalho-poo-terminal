package main.command;

import main.FileManager;
import main.PathManager;

public class CommandCat extends Command {
    @Override
    public String name() {
        return "cat";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length != 2) {
            System.out.println("cat: falta operando");

            return;
        }

        FileManager.readFile(
                PathManager
                        .getInstance()
                        .getCurrentPath()
                        .resolve(args[1])
                )
                .forEach(System.out::println);
    }
}
