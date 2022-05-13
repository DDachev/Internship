package FileStructure.Utility;

public class PathFolderManipulator {
    private static String getFirstFolder(String path) {
        String[] folders = path.trim().split("/");
        return folders[0];
    }
    public static String getLastFolder(String path) {
        int index = path.lastIndexOf('/');
        if (index == -1) {
            return path;
        }
        return path.substring(index + 1);
    }

    public static String getParentFolder(String path) {
        String[] folders = path.trim().split("/");
        if (folders.length > 0) {
            return path.substring(0, path.lastIndexOf('/'));
        }
        return "";
    }

    public static String getFolderName(String path) {
        String[] folders = path.trim().split("/");
        if (folders.length > 0) {
            return folders[folders.length - 1];
        }
        return "";
    }
}
