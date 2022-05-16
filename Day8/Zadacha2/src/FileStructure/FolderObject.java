package FileStructure;

import FileStructure.Utility.PathFolderManipulator;

import java.util.ArrayList;
import java.util.List;

public class FolderObject extends FileSystemObject {
    private List<FileSystemObject> children = new ArrayList<>();

    public FolderObject(String name) {
        super(name);
    }

    public FolderObject(String name, String parent) {
        super(name, parent);
    }

    private boolean checkIfChild(String path) {
        String parentFolder = PathFolderManipulator.getParentFolder(path);
        if (parentFolder != null) {
            return parentFolder.equals(this.getName());
        } else {
            return false;
        }
    }

    public boolean checkChildExists(String childName) {
        for (FileSystemObject child : this.children) {
            if (child.getName().equals(childName)) {
                return true;
            }
        }
        return false;
    }

    private FileSystemObject getChild(String childName) {
        for (FileSystemObject child : this.children) {
            if (child.getName().equals(childName)) {
                return child;
            }
        }
        return null;
    }

    @Override
    public String getChildren() {
        StringBuilder children = new StringBuilder();
        if (this.children.size() > 0) {
            for (FileSystemObject child : this.children) {
                children.append(child.getName()).append(", ");
            }
            return children.toString();
        } else {
            return this.getName() + " has no children";
        }
    }
    public List<FileSystemObject> getChildrenList() {
        return this.children;
    }

    @Override
    public void addChild(FileSystemObject child) {
        children.add(child);
    }
}
