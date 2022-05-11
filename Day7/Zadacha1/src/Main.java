import Files.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<File> directory = new ArrayList<>();
        getCommands(sc, directory);
    }

    private static void getCommands(Scanner sc, List<File> directory) {
        String[] userInput = sc.nextLine().split("\\s");
        while (!userInput[0].trim().equalsIgnoreCase("END")) {
            String command = userInput[0].trim();
            String fileName = userInput[1];

            File newFile = null;
            switch (command) {
                case "MAKE" -> {
                    String fileLocation = userInput[2];
                    if (userInput.length == 4) {
                        if (userInput[3].trim().startsWith("CONTENT")) {
                            String[] contentInput = userInput[3].split("=");
                            String content = contentInput[1].trim();

                            if (fileName.trim().endsWith(".avi") || fileName.trim().endsWith(".mp3")) {
                                newFile = new MediaContentFile(fileName, fileLocation, content);
                            } else {
                                newFile = new DocumentContentFile(fileName, fileLocation, content);
                            }
                        }
                    } else {

                        String[] resources = new String[userInput.length - 3];
                        System.arraycopy(userInput, 3, resources, 0, userInput.length - 3);
                        newFile = new ExecutableFile(fileName, fileLocation, resources);
                    }
                    directory.add(newFile);
                }
                case "MOVE" -> {
                    String fileLocation = userInput[2];
                    // directory.stream().filter(f -> f.getName().equals(fileName))
                    //       .findFirst().ifPresent(targetFile -> targetFile.move(fileLocation));
                    for (File file : directory) {
                        if (file.getName().equals(fileName)) {
                            file.move(fileLocation);
                        }
                    }
                }
                case "MOD" -> {
                    String newContent = userInput[2];
                    for (File file : directory) {
                        if (file.getName().equals(fileName)) {
                            file.modify(newContent);
                        }
                    }
                }
                case "COPY" -> {
                    String fileLocation = userInput[2];
                    File fileCopy = null;
                    for (File file : directory) {
                        if (file.getName().equals(fileName)) {
                            fileCopy = file.copy(fileLocation);
                        }
                    }
                    directory.add(fileCopy);
                }
                case "DEL" -> {
                    for (File file : directory) {
                        if (file.getName().equals(fileName)) {
                            file.delete();
                        }
                    }
                }
                case "EXEC" -> {
                    for(File file : directory) {
                        if(file instanceof ExecutableFile) {
                            ((ExecutableFile) file).execute();
                        } else if(file instanceof MediaContentFile) {
                            System.out.println("♫♫♫ " + ((MediaContentFile) file).getContent());
                        }
                        else if(file instanceof DocumentContentFile) {
                            System.out.println("✓✓✓ " + ((DocumentContentFile) file).getContent());
                        }
                    }
                }
                case "INFO" -> {
                    for (File file : directory) {
                        if (file.getName().equals(fileName)) {
                            file.getInfo();
                        }
                    }
                }
            }
            userInput = sc.nextLine().trim().split("\\s");
        }
    }
}