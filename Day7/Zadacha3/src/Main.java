import Bank.Accounts.Account;
import Bank.Accounts.DepositAccount;
import Bank.Accounts.LoanAccount;
import Bank.Accounts.MortgageAccount;
import Bank.Customers.CompanyCustomer;
import Bank.Customers.Customer;
import Bank.Customers.IndividualCustomer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Account> bank = new ArrayList<>();
        getCommands(sc, bank);
        for (Account account : bank) {
            System.out.println(account);
        }
    }

    private static void getCommands(Scanner sc, List<Account> bank) {
        String[] userInput = sc.nextLine().split("\\s");

        while (!userInput[0].trim().equalsIgnoreCase("END")) {
            String command = userInput[0].trim();

            switch (command) {
                case "OPEN" -> openAccount(userInput, bank);

                case "PUT" -> {
                    double amount = Double.parseDouble(userInput[2]);
                    bankTransaction("Deposit", userInput[1], amount, bank);
                }
                case "GET" -> {
                    double amount = Double.parseDouble(userInput[2]);
                    bankTransaction("Withdraw", userInput[1], amount, bank);
                }
                case "INFO" -> {
                    int numberOfMonths = Integer.parseInt(userInput[2]);
                    if (checkIfIBAN(userInput[1])) {
                        for (Account account : bank) {
                            if (account.getIBAN().equals(userInput[1])) {
                                System.out.println("Total interest for " + numberOfMonths + " months: " + account.printInterestInfo(numberOfMonths));
                            }
                        }
                    } else {
                        for (Account account : bank) {
                            if (account.getOwnerName().equals(userInput[1])) {
                                System.out.println("Total interest for " + numberOfMonths + " months: " + account.printInterestInfo(numberOfMonths));
                            }
                        }
                    }
                }
            }
            userInput = sc.nextLine().trim().split("\\s");
        }
    }

    public static void openAccount(String[] userInput, List<Account> bank) {
        String accountName = userInput[1];
        Customer owner;
        Account newAccount = null;

        if (Integer.parseInt(userInput[2]) == 1) {
            owner = new IndividualCustomer(accountName);
        } else {
            owner = new CompanyCustomer(accountName);
        }

        double balance = Double.parseDouble(userInput[4]);
        double monthlyInterestRate = Double.parseDouble(userInput[5]);

        switch (Integer.parseInt(userInput[3])) {
            case 1 -> newAccount = new DepositAccount(owner, balance, monthlyInterestRate);
            case 2 -> newAccount = new LoanAccount(owner, balance, monthlyInterestRate);
            case 3 -> newAccount = new MortgageAccount(owner, balance, monthlyInterestRate);
        }
        String newIBAN = generateIBAN(bank);
        if (newAccount != null) {
            newAccount.setIBAN(newIBAN);
            bank.add(newAccount);
        }
    }

    private static boolean checkIfIBAN(String input) {
        return input.matches("\\d+");
    }

    private static void bankTransaction(String transactionType, String input, double amount, List<Account> bank) {
        if (transactionType.equals("Deposit")) {
            if (checkIfIBAN(input)) {
                for (Account account : bank) {
                    if (account.getIBAN().equals(input)) {
                        account.deposit(amount);
                        System.out.println(account.getBalance());
                    }
                }
            } else {
                for (Account account : bank) {
                    if (account.getOwnerName().equals(input)) {
                        account.deposit(amount);
                        System.out.println(account.getBalance());
                    }
                }
            }
        } else if (transactionType.equals("Withdraw")) {
            if (checkIfIBAN(input)) {
                for (Account account : bank) {
                    if (account.getIBAN().equals(input) && account instanceof DepositAccount) {
                        ((DepositAccount) account).withdraw(amount);
                        System.out.println(account.getBalance());
                    }
                }
            } else {
                for (Account account : bank) {
                    if (account.getOwnerName().equals(input) && account instanceof DepositAccount) {
                        ((DepositAccount) account).withdraw(amount);
                        System.out.println(account.getBalance());
                    }
                }
            }
        }
    }

    private static String generateIBAN(List<Account> bank) {
        int bankAccountCount = bank.size();
        String IBAN;
        DecimalFormat df = new DecimalFormat("00000000");
        if (bankAccountCount == 0) {
            IBAN = "00000001";
        } else {
            IBAN = df.format(bankAccountCount + 1);
        }
        System.out.println(IBAN);
        return IBAN;
    }
}