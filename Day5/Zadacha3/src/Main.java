import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank newBank = new Bank();
        userInput(sc, newBank);

        System.out.println(newBank);
    }
    public static void userInput(Scanner sc, Bank bank) {
        String[] inputLine = sc.nextLine().split("\\s");

        String command="";
        while (!command.equalsIgnoreCase("END")) {
            command = inputLine[0];
            String username = inputLine[1];
            String password = inputLine[2];

            switch (command) {
                case "OPEN" -> {
                    String name = inputLine[3];
                    String govId = inputLine[4];
                    bank.openAccount(username, password, name, govId);
                }
                case "CLOSE" -> bank.closeAccount(username, password);
                case "DEPOSIT" -> {
                    double amount = Double.parseDouble(inputLine[2]);
                    bank.deposit(username, amount);
                }
                case "WITHDRAW" -> {
                    double amount = Double.parseDouble(inputLine[3]);
                    bank.withdraw(username, password, amount);
                }
                case "TRANSFER" -> {
                    double amount = Double.parseDouble(inputLine[3]);
                    String recipient = inputLine[4];
                    bank.transfer(username, password, amount, recipient);
                }
            }
            inputLine = sc.nextLine().split("\\s");
        }
    }
}
