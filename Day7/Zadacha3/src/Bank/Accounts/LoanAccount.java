package Bank.Accounts;

import Bank.Customers.Customer;
import Bank.Customers.IndividualCustomer;

public class LoanAccount extends Account {

    public LoanAccount(Customer owner, double balance, double monthlyInterestRate) {
        super(owner, balance, monthlyInterestRate);
    }

    @Override
    public double printInterestInfo(int periodInMonths) {
        double totalInterest;
        int validPeriod;
        if (owner instanceof IndividualCustomer) {
            validPeriod = periodInMonths-3;
            if (periodInMonths <= 3) {
                return 0;
            } else {
                totalInterest = (balance * monthlyInterestRate * validPeriod) / 100;
            }
        } else {
            validPeriod = periodInMonths-2;
            if (periodInMonths <= 2) {
                return 0;
            } else {
                totalInterest = (balance * monthlyInterestRate * validPeriod) / 100;
            }
        }
        return totalInterest;
    }

    @Override
    public String toString() {
        return "LoanAccount{" +
                "IBAN='" + IBAN + '\'' +
                ", owner=" + owner +
                ", balance=" + balance +
                ", monthlyInterestRate=" + monthlyInterestRate +
                '}';
    }


}
