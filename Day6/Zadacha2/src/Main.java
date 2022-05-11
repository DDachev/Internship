import University.Person;
import University.Student;
import University.Teacher;
import University.AdministrationEmployee;
import University.MaintenanceEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Person> university = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        getCommands(sc, university);
    }

    private static void getCommands(Scanner sc, List<Person> university) {
        String[] userInput = sc.nextLine().trim().split("\\s");
        while (!userInput[0].trim().equalsIgnoreCase("END")) {
            String command = userInput[0];

            Person person = null;
            switch (command) {
                case "NEW" -> {
                    String type = userInput[1];
                    String name = userInput[2];
                    String phone = userInput[3];

                    switch (type) {
                        case "MAINT" -> {
                            person = new MaintenanceEmployee(name, phone);
                        }
                        case "ADMIN" -> {
                            String[] subjects = new String[userInput.length - 4];
                            System.arraycopy(userInput, 4, subjects, 0, userInput.length - 4);
                            person = new AdministrationEmployee(name, phone, subjects);
                        }
                        case "TEACH" -> {
                            String[] subjects = new String[userInput.length - 4];
                            System.arraycopy(userInput, 4, subjects, 0, userInput.length - 4);
                            person = new Teacher(name, phone, subjects);
                        }
                        case "STUD" -> {
                            String facultyNumber = userInput[4];
                            String[] subjects = new String[userInput.length - 5];
                            System.arraycopy(userInput, 5, subjects, 0, userInput.length - 5);
                            person = new Student(name, phone, facultyNumber, subjects);
                        }
                    }
                    if (person != null) {
                        university.add(person);;
                    }
                }
                case "WORK" -> {
                 String personName = userInput[1];
                 System.out.println(personName + " is working");
                }
                case "IDLE" -> {
                    System.out.println("Nobody is working");
                }
            }

            userInput = sc.nextLine().trim().split("\\s");
        }
    }
}