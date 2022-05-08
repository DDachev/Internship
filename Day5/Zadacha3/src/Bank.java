import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
    private ArrayList<Account> accounts;
    private double assets;

    public Bank() {
        accounts = new ArrayList<>();
        assets = 0;
    }

    public void openAccount(String name, String govId, String username, String password) {
        if (accounts.size() < 5) {
            Account acc = new Account(username, govId, name, password);
            accounts.add(acc);
            System.out.println("OPEN success");
        } else {
            System.out.println("OPEN fail");
        }
    }

    public void closeAccount(String username, String password) {
        Account targetAccount = getAccount(username, password);
        Iterator<Account> itr = accounts.iterator();
        while (itr.hasNext()) {
            Account acc = itr.next();
            if (acc == targetAccount) {
                itr.remove();
                System.out.println("CLOSE success");
                return;
            }
        }
        System.out.println("CLOSE fail");
    }


    public void deposit(String username, double amount) {
        Account targetAccount = checkAccountExists(username);
        if (targetAccount != null) {
            if (targetAccount.deposit(amount)) {
                System.out.println("DEPOSIT success");
            } else {
                System.out.println("DEPOSIT fail");
            }
        } else {
            System.out.println("DEPOSIT fail");
        }
    }

    public void withdraw(String username, String password, double amount) {
        Account targetAccount = getAccount(username, password);

        if (targetAccount != null) {
            if (targetAccount.withdraw(amount)) {
                System.out.println("WITHDRAW success");
            } else {
                System.out.println("WITHDRAW fail");
            }
        } else {
            System.out.println("WITHDRAW fail");
        }
    }

    public void transfer(String username, String password, double amount, String recipient) {
        Account targetAccount = getAccount(username, password);
        Account targetRecipient = checkAccountExists(recipient);

        if (targetAccount.getBalance() >= amount) {

            if (targetRecipient != null) {
                targetAccount.withdraw(amount);
                targetRecipient.deposit(amount);
                System.out.println("TRANSFER success");
            } else {
                System.out.println("TRANSFER fail");
            }
        } else {
            System.out.println("TRANSFER fail");
        }
    }

    public Account getAccount(String username, String password) {
        Account targetAccount = checkAccountExists(username);

        if (targetAccount != null) {
            if (targetAccount.hasAccess(password)) {
                return targetAccount;
            }
        }
        return null;
    }

    public Account checkAccountExists(String username) {
        for (Account acc : accounts) {

            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }

    public double getAssets() {

        for (Account acc : accounts) {
            assets += acc.getBalance();
        }
        return assets;
    }

    @Override
    public String toString() {
        System.out.println(getAssets());
        StringBuilder sb = new StringBuilder();

        for (Account acc : accounts) {
            sb.append(acc.toString()).append("\n");
        }
        return sb.toString();
    }

}

