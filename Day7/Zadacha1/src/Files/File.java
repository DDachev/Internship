package Files;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class File {
    String name;
    String location;
    boolean isDeleted;
    String creationDateString;

    public File(String name, String location) {
        this.name = name;
        this.location = location;
        this.creationDateString = setCreationDate();
    }

    private String setCreationDate() {
        LocalDateTime creationDate = LocalDateTime.now();
        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        creationDateString = creationDate.format(myDateFormat);
        return creationDateString;
    }

    public void move(String newLocation) {
        this.location = newLocation;
    }

    public abstract File copy(String newLocation);

    public void delete() {
        isDeleted = true;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public String getInfo() {
        if (isDeleted) {
            return String.format("name: %s/%s [DELETED]\nCreation date: %s\n=====================", location, name, creationDateString);
        } else {
            return String.format("name: %s/%s\nCreation date: %s\n=====================", location, name, creationDateString);
        }
    }

    public String getName() {
        return name;
    }

    public void modify(String newContent) {
    }


    protected void execute() {
    }

}
