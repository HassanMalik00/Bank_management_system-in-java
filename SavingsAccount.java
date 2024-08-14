package mypackage.Bank_management_system;

public class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount(String accountNumber, User owner, double interestRate) {
        super(accountNumber, owner);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction(new Transaction("Deposit", amount, balance));
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction(new Transaction("Withdrawal", amount, balance));
            return true;
        }
        return false;
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        addTransaction(new Transaction("Interest", interest, balance));
    }

    @Override
    public String toString() {
        return super.toString() + "\nInterest Rate: " + interestRate;
    }
}
