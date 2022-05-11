import University.Person;

import java.util.ArrayList;
import java.util.List;

public class University {
    double balance = 500;
    List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}
