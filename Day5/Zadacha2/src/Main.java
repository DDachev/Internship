import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Напишете програма, която да чете редове от стандартния вход до въвеждането на команда END. Прочетените редове са във формата:
        //
        //<КОМАНДА> <ПОТРЕБИТЕЛСКО_ИМЕ> <ПАРОЛА> [<НОВА_ПАРОЛА>]
        //
        //Командите са ENROLL, CHPASS, AUTH, като ENROLL добавя нов потребител в „базата данни“ Credentials, CHPASS сменя паролата на съществуващ потребител, AUTH проверява въведена парола за съвпадение. След всяка команда на стандартния вход да се изписва командата и съобщение success или fail, в зависимост от резултата на изпълнение на командата.
        //
        ArrayList<Credentials> credentialsList = new ArrayList<>();
        String username, password;
        String newPassword = null;
        String[] command = sc.nextLine().split("\\s");
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
                            credential.changePassword(newPassword, password);
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