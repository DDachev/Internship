import java.util.ArrayList;

public class Credentials {
    private final String username;
    private String password;
    private ArrayList<String> oldPasswordList = new ArrayList<>();

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

    public boolean changePassword(String newPassword, String currentPassword) {
        if (authCheckBool(this.username, currentPassword)) {
            if (currentPassword.equals(newPassword)) {
                System.out.println("CHPASS fail");
                return false;
            }
            if (oldPasswordList.size() > 0) {
                if (!oldPasswordList.contains(newPassword)) {
                    this.password = newPassword;
                    System.out.println("CHPASS success");
                    return true;
                } else {
                    System.out.println("CHPASS fail");
                    return false;
                }
            } else {
                this.password = newPassword;
                oldPasswordList.add(currentPassword);
                System.out.println("CHPASS success");
                return true;
            }
        } else {
            System.out.println("CHPASS fail");
            return false;
        }
    }

    public String getUsername() {
        return username;
    }
}