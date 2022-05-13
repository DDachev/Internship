package FileStructure;

public class FileObject extends FileSystemObject {
    public FileObject(String path) {
        super(path);
        this.name = path.substring(path.lastIndexOf("/") + 1);

    }
}
