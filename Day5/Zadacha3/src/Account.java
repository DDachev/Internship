public class Account {
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
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public boolean hasAccess(String password) {
        //TODO: implement
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return this.name;
    }

    public String getGovId() {
        return govId;
    }

    public String getName() {
        return name;
    }

}
