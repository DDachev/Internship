package FileStructure.Utility;

import FileStructure.Exceptions.InvalidNameException;

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
        boolean flag = false;
        if (name.length() >= 1) {

            if (checkIfAlphaNumericAndSpecialChars(name)) {
                flag = true;
            } else if (!checkIfStartsWithSpecial(name)) {
                flag = true;
            } else if (validateExtension(name)) {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean validateExtension(String name) {
        String[] split = name.split("\\.");
        if (split.length > 1) {
            return split[split.length - 1].length() <= 6;
        } else {
            return false;
        }

    }

    public static boolean checkIfStartsWithSpecial(String name) {
        switch (name.charAt(0)) {
            case '.':
            case '_':
            case '!':
            case '&':
            case ' ':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }

    public static boolean checkIfAlphaNumericAndSpecialChars(String name) {
        String notAllowedChars = "$+,:;=?@#|'<>^*%-";
        for (int i = 0; i < notAllowedChars.length(); i++) {
            if (name.contains(notAllowedChars.charAt(i) + "")) {
                return false;
            }
        }

        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetterOrDigit(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
