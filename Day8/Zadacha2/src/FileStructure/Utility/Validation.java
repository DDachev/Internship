package FileStructure.Utility;

public class Validation {

    public static boolean checkIfFolder(String path) {
        return path.contains(".");
    }

    public static boolean checkIfPath(String path) {
        return path.contains("/");
    }

    public static boolean validatePathForCreatingFolder(String path) {
        return !checkIfFolder(path) && checkIfPath(path);
    }

    public static boolean validateName(String name) {
        if (name.length() >= 1) {
            if (name.matches("^[a-zA-Z\\d\\s()_!.&]+$")) {
                return true;
            }

            String[] split = name.split(".");
            if (split.length > 1) {
                return split[split.length - 1].length() <= 6;
            }

            switch (name.charAt(0)) {
                case '.':
                case '_':
                case '!':
                case '&':
                case ' ':
                case '(':
                case ')':
                    return false;
                default:
                    return true;
            }
        } else {
            return false;
        }
    }
}
