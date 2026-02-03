package main;

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
        CommandHandler commandHandler = new CommandHandler();
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
}

