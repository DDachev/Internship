package Bank.Accounts;

import Bank.Customers.Customer;
import Bank.Customers.IndividualCustomer;

public class MortgageAccount extends Account {

    public MortgageAccount(Customer owner, double balance, double monthlyInterestRate) {
        super(owner, balance, monthlyInterestRate);
    }

    @Override
    public double printInterestInfo(int periodInMonths) {
               int validPeriod;
        if (owner instanceof IndividualCustomer) {
            if (periodInMonths <= 6) {
                return 0;
            } else {
                validPeriod = periodInMonths - 6;
                return balance * monthlyInterestRate * validPeriod / 100;
            }
        } else if (periodInMonths <= 12) {
            return balance * monthlyInterestRate * periodInMonths / 100 / 2;
        } else {
            validPeriod = periodInMonths - 12;
            double halfInterest = balance * (monthlyInterestRate * 12) / 100 / 2;
            return halfInterest + (balance * (monthlyInterestRate * validPeriod) / 100);
        }
    }

    @Override
    public String toString() {
        return "MortgageAccount{" +
                "IBAN='" + IBAN + '\'' +
                ", owner=" + owner +
                ", balance=" + balance +
                ", monthlyInterestRate=" + monthlyInterestRate +
                '}';
    }
}
