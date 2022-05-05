import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private double assets;

    public Bank() {
        accounts = new ArrayList<Account>();
        assets = 0;
    }

    public void openAccount(String name, String govId, String username, String password) {
        if (accounts.size() < 5) {
            Account acc = new Account(name, govId, username, password);
            accounts.add(acc);
            System.out.println("OPEN success");
        } else {
            System.out.println("OPEN fail");
        }
    }

    public void closeAccount(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                if (acc.credentials.authCheckBool(username, password)) {
                    accounts.remove(acc);
                    System.out.println("CLOSE success");
                } else {
                    System.out.println("CLOSE fail");
                }
            }
        }
    }

    public void deposit(String username, double amount) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                acc.deposit(amount);
                System.out.println("DEPOSIT success");
            } else {
                System.out.println("DEPOSIT fail");
            }
        }
    }

    public void withdraw(String username, String password, double amount) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                if (acc.credentials.authCheckBool(username, password)) {
                    acc.withdraw(amount);
                    System.out.println("WITHDRAW success");
                } else {
                    System.out.println("WITHDRAW fail");
                }
            } else {
                System.out.println("WITHDRAW fail");
            }
        }
    }

    public void transfer(String username, String password, double amount, String recipient) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                if (acc.credentials.authCheckBool(username, password)) {
                    for (Account acc2 : accounts) {
                        if (acc2.getUsername().equals(recipient)) {
                            acc2.deposit(amount);
                            System.out.println("TRANSFER success");
                        } else {
                            System.out.println("TRANSFER fail");
                        }
                    }
                } else {
                    System.out.println("TRANSFER fail");
                }
            } else {
                System.out.println("TRANSFER fail");
            }
        }
    }

    public double getAssets() {
        for (Account acc : accounts) {
            assets += acc.getBalance();
        }
        return assets;
    }


}

