package FileStructure.Exceptions;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message, int lineNumber) {
        super(lineNumber + " - " + message);
    }
}
