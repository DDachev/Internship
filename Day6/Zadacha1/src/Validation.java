public class Validation {

    boolean name(String name, String parameter) {
        if (name.length() < 3 || name.length() > 30) {
            throw new IllegalArgumentException("Expected length for " + parameter + " is between 2 and 30 symbols.");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Expected only Latin letters for " + parameter + ".");
        }

        if (!Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter for first position of " + parameter + ".");
        }
        return true;
    }

    boolean facultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Expected length for faculty number is between 5 and 10 symbols. ");
        }
        return true;
    }

    boolean positiveNumber(int lectureCount, String parameter) {
        try {
            Integer.parseInt(String.valueOf(lectureCount));
        } catch (NumberFormatException e) {
            System.out.println(lectureCount + "Expected integer for " + parameter + ".");
        }

        if (lectureCount < 0) {
            throw new IllegalArgumentException("Expected positive number for " + parameter + ".");
        }
        return true;
    }
}
