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
        this.currentPath = Paths.get(System.getProperty("user.home")).toAbsolutePath();

        Path projectPath = Paths.get("").toAbsolutePath();
        this.fileHistoryPath = projectPath.resolve(NAME_HISTORY_FILE);
    }

    public void changeCurrentPath(String name) {
        Path newPath = currentPath.resolve(name).normalize();

        if (Files.isRegularFile(newPath)) {
            System.out.println("bash: cd: "+ name +": Não é um diretório");

            return;
        }

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
