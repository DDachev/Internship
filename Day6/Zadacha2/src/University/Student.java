package University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person {

    private String facultyNumber;
    private List<String> courses = new ArrayList<>();


    public Student(String name, String phone, String facultyNumber, String... courses) {
        super(name, phone);
        this.facultyNumber = facultyNumber;
        this.courses.addAll(Arrays.asList(courses));
    }

    public void Work() {
        System.out.println("Work " + this.name);
    }

}
