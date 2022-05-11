package Files;

public class DocumentContentFile extends ContentFile {
    public DocumentContentFile(String name, String location, String content) {
        super(name, location, content);
    }

    @Override
    public  File copy(String newLocation) {
        DocumentContentFile newFile = new DocumentContentFile(this.name, this.location, this.content);
        newFile.name = this.name;
        newFile.location = newLocation;
        newFile.content = this.content;
        newFile.creationDateString = this.creationDateString;
        newFile.isDeleted = this.isDeleted;
        return newFile;
    }
    @Override
    public String getContent() {
        return content;
    }


}
