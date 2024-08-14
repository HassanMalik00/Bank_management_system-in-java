
package mypackage.Bank_management_system;

import java.util.Date;

public class Transaction {
    private final String type;
    private final double amount;
    private final double postTransactionBalance;
    private final Date date;

    public Transaction(String type, double amount, double postTransactionBalance) {
        this.type = type;
        this.amount = amount;
        this.postTransactionBalance = postTransactionBalance;
        this.date = new Date();  // Current date and time
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction Type: " + type + "\nAmount: " + amount + "\nBalance After Transaction: " + postTransactionBalance + "\nDate: " + date;
    }
}

