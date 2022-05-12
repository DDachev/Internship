import java.util.ArrayList;
import java.util.List;

public class Credentials {
    private final String username;
    private String password;
    private List<String> oldPasswordList = new ArrayList<>();

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("Enroll success");
    }

    public void authCheck(String username, String password) {
        if (this.username.equals(username)) {
            if (password.equals(this.password)) {
                System.out.println("AUTH success");
            } else {
                System.out.println("AUTH fail");
            }
        }
    }

    private boolean authCheckBool(String username, String password) {
        if (this.username.equals(username)) {
            return password.equals(this.password);
        } else {
            return false;
        }
    }

    public void changePassword(String newPassword, String currentPassword) throws OldPasswordConflictException {
        int conflictIndex = OldPasswordConflictException.getPasswordConflictIndex(oldPasswordList, currentPassword, newPassword);
        if (conflictIndex != -1) {
            throw new OldPasswordConflictException("[Password matches a recently used one: " + conflictIndex + "]");
        }
    }

    public String getUsername() {
        return username;
    }
}