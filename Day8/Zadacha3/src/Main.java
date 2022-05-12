import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Credentials> credentialsList = new ArrayList<>();
        String username, password;
        String newPassword = null;
        String[] command = sc.nextLine().trim().split("\\s");
        while (!command[0].equalsIgnoreCase("END")) {
            username = command[1];
            password = command[2];

            if (command[0].equalsIgnoreCase("CHPASS") && command[3] != null) {
                newPassword = command[3];
            }

            switch (command[0]) {
                case "ENROLL":
                    Credentials credentials = new Credentials(username, password);
                    credentialsList.add(credentials);
                    break;
                case "CHPASS":
                    for (Credentials credential : credentialsList) {
                        if (credential.getUsername().equals(username)) {
                            try {
                                credential.changePassword(newPassword, password);
                            } catch (OldPasswordConflictException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;

                case "AUTH":
                    for (Credentials credential : credentialsList) {
                        if (credential.getUsername().equals(username)) {
                            credential.authCheck(username, password);
                        }
                    }
                    break;
            }
            command = sc.nextLine().split("\\s");
        }
    }
}