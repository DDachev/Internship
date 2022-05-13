package FileStructure;

import FileStructure.Exceptions.InvalidNameException;
import FileStructure.Utility.Validation;

public class FileSystemObject {
    String parent = "root";
    String name;


    public FileSystemObject(String name) {
        this.name = name;
    }

    public FileSystemObject(String name, String parent) {
        this.name = name;
        this.parent = parent;
    }
    public String getChildren(){
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Validation.validateName(name)) {
            this.name = name;
        } else {
            throw new InvalidNameException("1", "Invalid name specified");
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

    @Override
    public String toString() {
        return "parent='" + parent + '\'' +
                ", name='" + name + '\'';
    }
}
