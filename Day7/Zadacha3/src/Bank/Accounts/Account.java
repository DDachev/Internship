package Bank.Accounts;

import Bank.Customers.Customer;

public abstract class Account {
    String IBAN = null;
    Customer owner;
    double balance;
    double monthlyInterestRate;

    public Account(Customer owner, double balance, double monthlyInterestRate) {
        this.owner = owner;
        this.balance = balance;
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }
    public String getOwnerName() {
        return owner.getName();
    }

    public abstract double printInterestInfo(int periodInMonths);

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

