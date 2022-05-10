package Files;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContentFile extends File {
    private String content;
    String lastModifiedDateString;

    public ContentFile(String name, String location, String content) {
        super(name, location);
        this.content = content;
        lastModifiedDateString = setLastModifiedDate();
    }

    private String setLastModifiedDate() {
        LocalDateTime lastModifiedDate = LocalDateTime.now();
        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        lastModifiedDateString = lastModifiedDate.format(myDateFormat);
        return lastModifiedDateString;
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
