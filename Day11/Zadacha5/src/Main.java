import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> graphicFiles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            String[] inputArr = input.split("\\.");
            if (inputArr.length != 2) {
                System.out.println("Invalid input.");
            } else {
                String name = inputArr[0];
                System.out.println(name);
                String extension = inputArr[1];
                System.out.println(extension);
                switch (extension) {
                    case "jpg", "jpeg", "png", "gif", "bmp":
                        graphicFiles.add(name + extension);
                        break;
                    default:
                        System.out.println();
                }
            }
        }
        System.out.println(graphicFiles.size());
        for (String file : graphicFiles) {
            System.out.println(file);
        }
    }
}