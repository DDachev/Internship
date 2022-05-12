package FileStructure;

import java.util.ArrayList;
import java.util.List;

public class FolderObject extends FileSystemObject {
    private List<FileSystemObject> children = new ArrayList<>();

    public FolderObject(String name, String path) {
        super(name, path);
    }

    private static String extractParentFolder(String path) {

        int lastSlash = path.lastIndexOf("/");
        if (lastSlash == -1) {
            return "";
        }
        int secondLastSlash = path.lastIndexOf("/", lastSlash - 1);
        if (secondLastSlash == -1) {
            return "";
        }
        return path.substring(secondLastSlash + 1, lastSlash);
    }
}
