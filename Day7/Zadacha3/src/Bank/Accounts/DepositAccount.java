package Bank.Accounts;

import Bank.Customers.Customer;

public class DepositAccount extends Account {

    public DepositAccount(Customer owner, double balance, double monthlyInterestRate) {
        super(owner, balance, monthlyInterestRate);
    }

    public void withdraw(double amount) {
        if (balance - amount > 0 && amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Invalid amount");
        }
    }
    @Override
    public double printInterestInfo(int periodInMonths){
        return balance * monthlyInterestRate * periodInMonths / 100;
    }


    @Override
    public String toString() {
        return "DepositAccount{" +
                "IBAN='" + IBAN + '\'' +
                ", owner=" + owner +
                ", balance=" + balance +
                ", monthlyInterestRate=" + monthlyInterestRate +
                '}';
    }
}
