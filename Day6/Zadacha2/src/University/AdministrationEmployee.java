package University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdministrationEmployee extends Employee {
    private List<String> subjects = new ArrayList<>();
    private final double salary = 19;

    public AdministrationEmployee(String name, String phone, String... subjects) {
        super(name, phone);
        this.subjects.addAll(Arrays.asList(subjects));
    }
}
