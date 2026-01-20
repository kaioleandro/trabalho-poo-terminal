package main;

public class Terminal {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        PathManager pathManager = PathManager.getInstance();

        DirectoryManager.createDirectory(pathManager.getCurrentPath().resolve("home"));
        pathManager.changeCurrentPath("home");

    }
}
