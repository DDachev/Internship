package FileStructure.Utility;

import FileStructure.Exceptions.InvalidNameException;
import FileStructure.FileObject;
import FileStructure.FileSystemObject;
import FileStructure.FolderObject;

import java.util.List;
import java.util.Scanner;

import static FileStructure.Utility.PathFileManipulator.getFileName;
import static FileStructure.Utility.Validation.validateName;
import static FileStructure.Utility.Validation.validatePathForCreatingFolder;

public class CommandExecutor {
    public static void handleInput(Scanner sc, List<FileSystemObject> fileSystem) {
        int commandCounter = 1;
        String input;
        while (!((input = sc.nextLine().trim()).equalsIgnoreCase("END"))) {
            String[] inputLine = input.split("\\s+");
            String commandName = inputLine[0];
            String path = inputLine[1];

            if (commandName.equals("mkdir")) {
                createFolder(path, fileSystem, commandCounter);
            } else if (commandName.equals("touch")) {
                createFile(path, fileSystem, commandCounter);
            } else {
                System.out.println("Invalid command");
            }
            commandCounter++;
        }
        System.out.println("Commands count: " + (commandCounter - 1));
    }

    public static void createFolder(String path, List<FileSystemObject> fileSystem, int commandCounter) {
        FileSystemObject newFolder;
        if (commandCounter == 1) {
            newFolder = new FolderObject(path);
            fileSystem.add(newFolder);
        } else {
            if (validatePathForCreatingFolder(path)) {
                String name = PathFolderManipulator.getFolderName(path);
                String parent = PathFolderManipulator.getParentFolder(path);
                newFolder = new FolderObject(name, parent);
                fileSystem.add(newFolder);
                PathFolderManipulator.addChildFolder(path, newFolder, fileSystem, commandCounter);
            }
        }
    }


    public static void createFile(String path, List<FileSystemObject> fileSystem, int commandCounter) {
        FileSystemObject newFile;
        String name = getFileName(path);
        String parent = PathFolderManipulator.getParentFolder(path);

        newFile = new FileObject(name, parent);
        if (validateName(name)) {
            fileSystem.add(newFile);
        } else {
            throw new InvalidNameException("Invalid name specified", commandCounter);
        }
    }
}
