import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        List<File> files = new ArrayList<>();
        List<File> directories = new ArrayList<>();

        printDirectories(path, directories);
        printFiles(path, files);
    }

    public static void printDirectories(String directoryName, List<File> directories) {
        getDirectories(directoryName, directories);
        for (File directory : directories) {
            System.out.println(directory.getAbsolutePath());
        }
    }

    public static void printFiles(String directoryName, List<File> files) {
        getFiles(directoryName, files);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public static void getFiles(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    getFiles(file.getAbsolutePath(), files);
                }
            }
        }
    }

    public static void getDirectories(String directoryName, List<File> directories) {
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isDirectory()) {
                    directories.add(file);
                }
            }
        }
    }
}