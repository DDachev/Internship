import FileStructure.FileSystemObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static FileStructure.Utility.CommandExecutor.handleInput;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<FileSystemObject> fileSystem = new ArrayList<>();

        handleInput(sc, fileSystem);

        for (FileSystemObject file : fileSystem) {
            System.out.println(file.toString());
            System.out.println(file.getChildren());
        }
    }
}