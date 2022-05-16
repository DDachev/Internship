package FileStructure.Utility;

public class PathFileManipulator {
    public static String getFileName(String path) {
        int lastSlash = path.lastIndexOf("/");
        if (lastSlash == -1) {
            return path;
        }
        return path.substring(lastSlash + 1);
    }

    public static String getFileExtension(String path) {
        int lastDot = path.lastIndexOf(".");
        if (lastDot == -1) {
            return "";
        }
        return path.substring(lastDot + 1);
    }

    public static String getFileNameWithoutExtension(String path) {
        int lastSlash = path.lastIndexOf("/");
        if (lastSlash == -1) {
            return path;
        }
        int lastDot = path.lastIndexOf(".");
        if (lastDot == -1) {
            return path.substring(lastSlash + 1);
        }
        return path.substring(lastSlash + 1, lastDot);
    }


}
