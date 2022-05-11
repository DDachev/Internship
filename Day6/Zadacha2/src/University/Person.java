package University;

public abstract class Person {
    String name;
    String phone;
    int tolerance = 20;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
}
