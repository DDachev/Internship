package FileStructure;

import FileStructure.Exceptions.InvalidNameException;
import FileStructure.Utility.Validation;

import java.util.List;

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

    public String getChildren() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addChild(FileSystemObject folder) {
    }

    public boolean checkChildExists(String targetFolder) {
        return false;
    }

    public List<FileSystemObject> getChildrenList() {
        return null;
    }
}
