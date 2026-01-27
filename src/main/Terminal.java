package main;

import java.util.Scanner;

public class Terminal {


    public static void main(String[] args) {
        start();
    }

    private static void start() {
        PathManager pathManager = PathManager.getInstance();

        DirectoryManager.createDirectory(pathManager.getRootPath());
        FileManager.CreateFile(pathManager.getFileHistoryPath());

        consoleListener();
    }

    private static void consoleListener() {
        PathManager pathManager = PathManager.getInstance();
        CommandHandler commandHandler = new CommandHandler();
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                String path = pathManager.getCurrentPath().toString();
                int index = path.indexOf("home/user");

                System.out.print(path
                        .substring(index + "home/user".length())
                        .concat("> ")
                );

                String consoleInput = input.nextLine();

                FileManager.AppendFile(
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

