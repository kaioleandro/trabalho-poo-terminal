package main;

import java.util.Scanner;

public class Terminal {


    public static void main(String[] args) {
        start();
    }

    private static void start() {
        PathManager pathManager = PathManager.getInstance();
        String rootDirectory = "home/user";

        DirectoryManager.createDirectory(pathManager.getCurrentPath().resolve(rootDirectory));
        pathManager.changeCurrentPath(rootDirectory);

        consoleListener(pathManager, rootDirectory);
    }

    private static void consoleListener(PathManager pathManager, String rootDirectory) {
        CommandHandler commandHandler = new CommandHandler();
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                String path = pathManager.getCurrentPath().toString();
                int index = path.indexOf(rootDirectory);

                System.out.print(path
                        .substring(index + rootDirectory.length())
                        .concat("> ")
                );

                commandHandler.catchCommand(input.nextLine());
            } catch (Exception e) {
                input.close();
                break;
            }
        }
    }
}

