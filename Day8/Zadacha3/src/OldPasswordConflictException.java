import java.util.List;

public class OldPasswordConflictException extends Exception {
    public OldPasswordConflictException(String message) {
        super(message);
    }

    public static int getPasswordConflictIndex(List<String> passwords, String currentPassword, String newPassword) {

        if (currentPassword.equals(newPassword)) {
            return 0;
        } else {
            for (int i = 0; i < passwords.size(); i++) {
                if (passwords.get(i).equals(newPassword)) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
