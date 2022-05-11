package Files;

public class MediaContentFile extends ContentFile {
    public MediaContentFile(String name, String location, String content) {
        super(name, location, content);
    }

    @Override
    public File copy(String newLocation) {
        MediaContentFile newFile = new MediaContentFile(this.name, this.location, this.content);
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
