package FileStructure.Exceptions;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message, String lineNumber) {
        super(lineNumber + " - " + message);
    }
}
