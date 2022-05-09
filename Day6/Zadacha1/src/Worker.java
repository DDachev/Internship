public class Worker {
    private String firstName;
    private String lastName;
    private double weekSalary;
    private int workHoursPerDay;
    Validation validate = new Validation();

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
        if (validate.name(firstName, "First name") && validate.name(lastName, "Last name")) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        if (validate.positiveNumber((int) weekSalary, "week salary") && validate.positiveNumber(workHoursPerDay, "work hours per day")) {
            this.weekSalary = weekSalary;
            this.workHoursPerDay = workHoursPerDay;
        }
    }

    private String getOccupation() {
        return "Worker";
    }

    private double calculateSalaryPerHour() {
        return this.weekSalary / (this.workHoursPerDay * 5);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s ", "First name", this.firstName));
        sb.append(String.format("\n%s: %s ", "Last name", this.lastName));
        sb.append(String.format("\n%s: %s", "Occupation", this.getOccupation()));
        sb.append(String.format("\n%s: %.2f", "Week salary", this.weekSalary));
        sb.append(String.format("\n%s: %.6f", "Hours per day", (double) this.workHoursPerDay));
        sb.append(String.format("\n%s: %.2f", "Salary per hour", this.calculateSalaryPerHour()));

        return sb.toString();
    }
}
