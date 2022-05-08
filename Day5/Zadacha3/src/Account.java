public class Account extends Bank {
    private final String username;
    private final String password;
    private final String name;
    private final String govId;
    private double balance = 0;

    public Credentials credentials;

    public Account(String username, String password, String name, String govId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.govId = govId;
        this.credentials = new Credentials(username, password);
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (balance - amount >= 0) {
                balance -= amount;
                return true;
            }
        }
        return false;
    }

    public boolean hasAccess(String password) {
        return credentials.authCheck(password);
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + ", " + govId + ", " + String.format("%.2f", balance);
    }
}
