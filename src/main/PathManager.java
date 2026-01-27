package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathManager {
    private static PathManager instance;
    private final Path rootPath;
    private final Path fileHistoryPath;
    private Path currentPath;

    public static final String NAME_ROOT = "home/user";
    public static final String NAME_HISTORY_FILE = "history.txt";

    public static PathManager getInstance() {
        if( instance == null) {
            instance = new PathManager();
        }

        return instance;
    }

    private PathManager() {
        Path initialPath = Paths.get("").toAbsolutePath().resolve(NAME_ROOT);;

        this.fileHistoryPath = initialPath.resolve(NAME_HISTORY_FILE);
        this.rootPath = initialPath;
        this.currentPath = initialPath;
    }

    public void changeCurrentPath(String name) {
        Path path = currentPath.resolve(name).normalize();

        if(!Files.isDirectory(path)) {
            System.out.println("Diretório não encontrado");
            return;
        }

        this.currentPath = path;
    }

    public Path getCurrentPath() {
        return currentPath;
    }

    public Path getRootPath() { return rootPath;}

    public Path getFileHistoryPath() { return fileHistoryPath; }
}
