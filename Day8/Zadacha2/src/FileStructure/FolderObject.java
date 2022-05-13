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
        return parentFolder.equals(this.getName());
    }

    @Override
    public String getChildren() {
        StringBuilder children = new StringBuilder();
        if (this.children.size() > 0) {
            for (FileSystemObject child : this.children) {
                children.append(child.getName()).append(" ");
            }
            return children.toString();
        } else {
            return "no children";
        }
    }

    public void addChild(FileSystemObject child) {
        children.add(child);
    }

}
