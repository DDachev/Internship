import java.util.ArrayList;

public class Credentials {
    private final String username;
    private final String password;
    private ArrayList<String> oldPasswordList = new ArrayList<>();

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean authCheck(String password) {
        return password.equals(this.password);
    }
}