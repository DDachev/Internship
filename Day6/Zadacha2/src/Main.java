import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Employee> university = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        getCommands(sc, university);
    }
    private static void getCommands(Scanner sc, List<Employee> university) {
        String[] userInput = sc.nextLine().split("\\s");
        while (!userInput[0].trim().equalsIgnoreCase("END")) {
            String studentFirstName = userInput[0];
            String studentLastName = userInput[1];

            userInput = sc.nextLine().trim().split("\\s");
        }
    }
}