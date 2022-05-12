import FileStructure.FileObject;
import FileStructure.FileSystemObject;
import FileStructure.FolderObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        List<FileSystemObject> fileSystem = new ArrayList<>();
        while (!command.trim().equalsIgnoreCase("END")) {
            String[] tokens = command.split("\\s");
            String commandName = tokens[0];
            String path = tokens[1];

            switch (commandName) {
                case "mkdir":
                    FileSystemObject newFolder;
                    String[] folders = extractPathFolders(path);
                    String lastFolder = extractLastFolder(path);

                    fileSystem.add(newFolder = new FolderObject(lastFolder, path));
                    break;
                case "touch":
                    FileSystemObject newFile;
                    String fileName = extractLastFolder(path);
                    String filePath = extractPath(path);
                    fileSystem.add(newFile = new FileObject(fileName, filePath));

                    break;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
            command = sc.nextLine();

        }
    }


    private static String extractLastFolder(String path) {
        int index = path.lastIndexOf('/');
        if (index == -1) {
            return path;
        }
        return path.substring(index + 1);
    }

    private static String extractPath(String path) {
        int index = path.lastIndexOf('/');
        if (index == -1) {
            return "";
        }
        return path.substring(0, index);
    }

    private static String[] extractPathFolders(String path) {
        int index = path.lastIndexOf('/');
        if (index == -1) {
            return new String[0];
        }
        return path.substring(0, index).split("/");
    }
}