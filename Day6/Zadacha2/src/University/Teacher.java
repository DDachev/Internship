package University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher extends Employee {
    private List<String> subjects = new ArrayList<>();
    double salary = 25;

    public Teacher(String name, String phone,String... subjects) {
        super(name, phone);
        this.subjects.addAll(Arrays.asList(subjects));
    }
}
