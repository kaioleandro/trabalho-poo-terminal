import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathManager {
    private static PathManager instance;
    private Path currentPath;

    public static PathManager getInstance() {
        if( instance == null) {
            instance = new PathManager();
        }

        return instance;
    }

    private PathManager() {
        this.currentPath = Paths.get("").toAbsolutePath();
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
}
