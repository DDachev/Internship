import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank newBank = new Bank();
        String[] command = sc.nextLine().split("\\s");
        while (!command[0].equals("END")) {
            String username = command[1];
            String password = command[2];

            switch (command[0]) {
                case "OPEN" -> {
                    String name = command[3];
                    String govId = command[4];
                    newBank.openAccount(username, password, name, govId);
                }
                case "CLOSE" -> newBank.closeAccount(username, password);
                case "DEPOSIT" -> {
                    double amount = Double.parseDouble(command[2]);
                    newBank.deposit(username, amount);
                }
                case "WITHDRAW" -> {
                    double amount = Double.parseDouble(command[3]);
                    newBank.withdraw(username, password, amount);
                }
                case "TRANSFER" -> {
                    double amount = Double.parseDouble(command[3]);
                    String recipient = command[4];
                    newBank.transfer(username, password, amount, recipient);
                }
            }

            command = sc.nextLine().split("\\s");
        }
        System.out.println(newBank.getAssets());
    }
}
