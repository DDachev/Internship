package Files;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContentFile extends File {
    String content;
    String lastModifiedDateString;

    public ContentFile(String name, String location, String content) {
        super(name, location);
        this.content = content;
        lastModifiedDateString = setLastModifiedDate();
    }

    @Override
    public  File copy(String newLocation) {
        ContentFile newFile = new ContentFile(this.name, this.location, this.content);
        newFile.name = this.name;
        newFile.location = newLocation;
        newFile.content = this.content;
        newFile.creationDateString = this.creationDateString;
        newFile.isDeleted = this.isDeleted;
        return newFile;
    }
    private String setLastModifiedDate() {
        LocalDateTime lastModifiedDate = LocalDateTime.now();
        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        lastModifiedDateString = lastModifiedDate.format(myDateFormat);
        return lastModifiedDateString;
    }

    public String getContent() {
        return content;
    }
    @Override
    public void modify(String newContent) {
        content = newContent;
        lastModifiedDateString = setLastModifiedDate();
    }

    @Override
    public void execute() {
        System.out.println("Executing " + name);
        lastModifiedDateString = setLastModifiedDate();
    }

    @Override
    public String getInfo() {
        if (isDeleted) {
            return String.format("name: %s/%s [DELETED]\nCreation date: %s\n=====================", location, name, creationDateString);
        } else {
            return String.format("name: %s/%s\nCreation date: %s\n%s\nLast modification date: %s\n=====================", location, name, creationDateString, content, lastModifiedDateString);
        }
    }

}
