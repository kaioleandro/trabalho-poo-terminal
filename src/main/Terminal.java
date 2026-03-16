package main;

import main.factory.CommandFactory;
import main.factory.LinuxCommandFactory;
import main.factory.WindowsCommandFactory;

import java.util.Scanner;

public class Terminal {


    public static void main(String[] args) {
        start();
    }

    private static void start() {
        PathManager pathManager = PathManager.getInstance();

        FileManager.CreateFile(pathManager.getFileHistoryPath());

        consoleListener();
    }

    private static void consoleListener() {
        PathManager pathManager = PathManager.getInstance();
        CommandHandler commandHandler = new CommandHandler(commandFactoryDecider());
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(pathManager.getCurrentPath() + "> ");

                String consoleInput = input.nextLine();

                FileManager.appendFile(
                        pathManager.getFileHistoryPath(),
                        consoleInput + System.lineSeparator()
                );

                commandHandler.catchCommand(consoleInput);
            } catch (Exception e) {
                input.close();
                break;
            }
        }
    }

    private static CommandFactory commandFactoryDecider(){
        String os = System.getProperty("os.name");

        return switch (os) {
            case "Linux" -> new LinuxCommandFactory();
            case "Windows" -> new WindowsCommandFactory();
            default -> throw new RuntimeException("Sistema operacional não encontrado");
        };
    }
}

