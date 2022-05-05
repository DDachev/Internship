import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Employee> employeesList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] employeeInfo = input.split(", ");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];

            if (employeeInfo.length == 5) {
                int age = Integer.parseInt(employeeInfo[4]);
                Employee newEmployee = new Employee(name, salary, position, department, age);
                employeesList.add(newEmployee);
            } else if (employeeInfo.length == 6) {
                String email = employeeInfo[5];
                Employee newEmployee = new Employee(name, salary, position, department, email);
                employeesList.add(newEmployee);
            } else {
                Employee newEmployee = new Employee(name, salary, position, department);
                employeesList.add(newEmployee);
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(employeesList.get(i));
        }
    }

    public static ArrayList<Employee> getSortedEmployees(ArrayList<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        return employees;
    }
}