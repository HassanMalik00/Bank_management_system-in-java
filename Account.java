package mypackage.Bank_management_system;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected User owner;
    protected List<Transaction> transactionHistory;

    // Constructor
    public Account(String accountNumber, User owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    protected void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nBalance: " + balance + "\nOwner: " + owner.getName();
    }
}
