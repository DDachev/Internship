
public class Employee {
    private final String name;
    private final double salary;
    private final String position;
    private final String department;
    private int age;
    private String email;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, int age, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        if (email != null) {
            return name + ", " + position + ", " + department + ", " + email;
        } else {
            return name + ", " + position + ", " + department;
        }
    }
}


