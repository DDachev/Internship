import java.util.List;

public class Student extends Person {
    private String name;
    private String phone;
    private String facultyNumber;
    private List<String> courses;
    private int tolerance;


    public Student(String name, String phone, String facultyNumber, List<String> courses) {
        super();
        this.tolerance = super.tolerance;
        this.name = name;
        this.phone = phone;
        this.facultyNumber = facultyNumber;
    }

    public void Work() {
        System.out.println("Work " + name);
    }

}
