import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Worker> workers = new ArrayList<>();
        getCommands(sc, students, workers);
    }

    private static void getCommands(Scanner sc, List<Student> students, List<Worker> workers) {
        String[] userInput = sc.nextLine().split("\\s");
        while (!userInput[0].trim().equalsIgnoreCase("END")) {
            String studentFirstName = userInput[0];
            String studentLastName = userInput[1];

            if (userInput.length == 5) {
                String studentFacultyNumber = userInput[2];
                int lecturesCount = Integer.parseInt(userInput[3]);
                int exercisesCount = Integer.parseInt(userInput[4]);

                Student student = new Student(studentFirstName, studentLastName, studentFacultyNumber, lecturesCount, exercisesCount);
                System.out.println(student);
                students.add(student);
            } else {
                double weekSalary = Double.parseDouble(userInput[2]);
                int workHours = Integer.parseInt(userInput[3]);

                Worker worker = new Worker(studentFirstName, studentLastName, weekSalary, workHours);
                System.out.println(worker);
                workers.add(worker);
            }

            userInput = sc.nextLine().trim().split("\\s");
        }
    }
}