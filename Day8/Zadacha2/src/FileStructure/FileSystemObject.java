package FileStructure;

import FileStructure.Exceptions.InvalidNameException;

public class FileSystemObject {
    String parent;
    String name;
    String path;

    public FileSystemObject(String name, String path) {
        this.name = name;
        this.setParent(path);
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        } else {
            throw new InvalidNameException("Invalid name specified");
        }
    }

    public void setParent(String path) {
        String[] split = path.split("/");

        if (split.length >= 2) {
            parent = split[split.length - 2];
        } else {
            parent = path;
        }
    }

    public String getParent() {
        return parent;
    }


    private boolean validateName(String name) {
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
