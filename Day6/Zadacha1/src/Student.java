public class Student {
    private String firstName;
    private String lastName;
    private String facultyNumber;
    private int lectureCount;
    private int exerciseCount;
    Validation validate = new Validation();

    public Student(String firstName, String lastName, String facultyNumber, int lectureCount, int exerciseCount) {
        if (validate.name(firstName, "First name") && validate.name(lastName, "Last name")) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        if (validate.facultyNumber(facultyNumber)) {
            this.facultyNumber = facultyNumber;
        }

        if (validate.positiveNumber(lectureCount, "Lecture count") && validate.positiveNumber(exerciseCount, "Exercise count")) {
            this.lectureCount = lectureCount;
            this.exerciseCount = exerciseCount;
        }
    }

    public String getOccupation() {
        return "Student";
    }

    private double calculateHoursPerDay() {
        int minutesLecture = this.lectureCount * 120;
        int minutesExercise = this.exerciseCount * 90;
        int minutesTotal = minutesLecture + minutesExercise;
        return (double) (minutesTotal / 60) / 5;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s ", "First name", this.firstName));
        sb.append(String.format("\n%s: %s ", "Last name", this.lastName));
        sb.append(String.format("\n%s: %s", "Occupation", this.getOccupation()));
        sb.append(String.format("\n%s: %s", "Faculty number", this.facultyNumber));
        sb.append(String.format("\n%s: %.2f", "Hours per day", this.calculateHoursPerDay()));
        return sb.toString();
    }
}
