package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathManager {
    private static PathManager instance;

    private final Path fileHistoryPath;
    private Path currentPath;

    public static final String NAME_HISTORY_FILE = "history.txt";

    public static PathManager getInstance() {
        if (instance == null) {
            instance = new PathManager();
        }
        return instance;
    }

    private PathManager() {
        Path initialPath = Paths.get(System.getProperty("user.home")).toAbsolutePath();

        this.currentPath = initialPath;

        Path projectPath = Paths.get("").toAbsolutePath();
        this.fileHistoryPath = projectPath.resolve(NAME_HISTORY_FILE);
    }

    public void changeCurrentPath(String name) {
        Path newPath = currentPath.resolve(name).normalize();

        if (!Files.exists(newPath) || !Files.isDirectory(newPath)) {
            System.out.println("bash: cd: "+ name +": Arquivo ou diretório inexistente");
            return;
        }

        this.currentPath = newPath;
    }

    public Path getCurrentPath() {
        return currentPath;
    }

    public Path getFileHistoryPath() {
        return fileHistoryPath;
    }
}
