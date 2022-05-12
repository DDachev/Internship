package FileStructure.Exceptions;

public class NotExistingDirectoryException extends RuntimeException {
    public NotExistingDirectoryException(String message) {
        super(message);
    }
}
