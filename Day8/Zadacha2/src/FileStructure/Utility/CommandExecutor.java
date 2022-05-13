package FileStructure.Utility;

import FileStructure.FileObject;
import FileStructure.FileSystemObject;
import FileStructure.FolderObject;

import java.util.List;
import java.util.Scanner;

import FileStructure.Utility.PathFolderManipulator;

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
                createFile(path, fileSystem);
            } else {
                System.out.println("Invalid command");
            }
            commandCounter++;
        }
    }

    public static void createFolder(String path, List<FileSystemObject> fileSystem, int commandCounter) {
        FileSystemObject newFolder = null;
        if (commandCounter == 1) {
            newFolder = new FolderObject(path);
        } else {
            if (validatePathForCreatingFolder(path)) {
                String name = PathFolderManipulator.getFolderName(path);
                String parent = PathFolderManipulator.getParentFolder(path);
                newFolder = new FolderObject(name, parent);
                fileSystem.add(newFolder);
               
            }
        }
    }




    public static void createFile(String path, List<FileSystemObject> fileSystem) {
        FileSystemObject newFile;

        newFile = new FileObject(path);
        fileSystem.add(newFile);
    }
}
