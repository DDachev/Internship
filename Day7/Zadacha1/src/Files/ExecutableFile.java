package Files;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecutableFile extends File {
    private String lastExecutionDateString;
    List<String> requiredResources = new ArrayList<>();

    public ExecutableFile(String name, String location, String... resource) {
        super(name, location);
        requiredResources.addAll(Arrays.asList(resource));
    }

    public File copy(String newLocation) {
        File newFile = new ExecutableFile(this.name, this.location);
        newFile.name = this.name;
        newFile.location = newLocation;
        newFile.creationDateString = this.creationDateString;
        newFile.isDeleted = this.isDeleted;
        return newFile;
    }

    private String setLastExecutionDate() {
        LocalDateTime lastExecutionDate = LocalDateTime.now();
        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        lastExecutionDateString = lastExecutionDate.format(myDateFormat);
        return lastExecutionDateString;
    }

    @Override
    public String getInfo() {
        if (isDeleted) {
            return String.format("name: %s/%s [DELETED]\nCreation date: %s\nLast execution date: %s\n=====================", location, name, creationDateString, lastExecutionDateString);
        } else {
            return String.format("name: %s/%s\nCreation date: %s\nLast execution date: %s\n=====================", location, name, creationDateString, lastExecutionDateString);
        }
    }

    @Override
    public void modify(String newContent) {
    }

    @Override
    public void execute() {
        System.out.println("Executing " + location + "/" + name);
        List<File> resources = new ArrayList<>();
        for (String fileName : requiredResources) {
            //TODO: implement
        }

        lastExecutionDateString = setLastExecutionDate();
    }
}
