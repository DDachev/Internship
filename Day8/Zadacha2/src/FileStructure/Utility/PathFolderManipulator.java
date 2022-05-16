package FileStructure.Utility;

import FileStructure.Exceptions.NotExistingDirectoryException;
import FileStructure.FileSystemObject;
import FileStructure.FolderObject;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathFolderManipulator {
    private static String getFirstFolder(String path) {
        Path p = Paths.get(path);
        return p.getName(0).toString();
    }

    public static String getParentFolder(String path) {
        Path p = Paths.get(path);
        if (p.getNameCount() == 1) {
            return p.getFileName().toString();
        } else if (p.getNameCount() >= 2) {
            return p.getName(p.getNameCount() - 2).toString();
        }
        return null;
    }

    public static String getFolderName(String path) {
        Path p = Paths.get(path);
        return p.getFileName().toString();
    }

    public static FolderObject getParentIfExists(String path, List<FileSystemObject> fileSystem) {
        String parent = getParentFolder(path);

        for (FileSystemObject folder : fileSystem) {
            if (folder.getName().equals(parent)) {
                return (FolderObject) folder;
            }
        }
        return null;
    }

    public static void addChildFolder(String path, FileSystemObject child, List<FileSystemObject> fileSystem, int commandCounter) {
        FileSystemObject parent = getParentIfExists(path, fileSystem);
        if (parent != null) {
            parent.addChild(child);
        } else {
            throw new NotExistingDirectoryException(commandCounter + " - Directory does not exist");
        }
    }
}
