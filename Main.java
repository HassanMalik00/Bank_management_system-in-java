package mypackage.Bank_management_system;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank bank = Bank.getInstance();

    public static void main(String[] args) {
        bank.loadFromFile();  // Load data from file on startup
        
        boolean running = true;

        while (running) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Login");
            System.out.println("2. Create User");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        bank.saveToFile();  // Save data to file before exiting
    }

    private static void login() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = bank.getUser(userId);

        if (user != null && user.verifyPassword(password)) {
            System.out.println("Login successful!");
            manageAccount(user);
        } else {
            System.out.println("Invalid user ID or password.");
        }
    }

    private static void manageAccount(User user) {
        boolean managing = true;

        while (managing) {
            System.out.println("\n--- Account Management ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Details");
            System.out.println("5. View Transaction History");
            System.out.println("6. Delete Account");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount(user);
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    viewAccountDetails();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    deleteAccount();
                    break;
                case 7:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

 private static void createAccount(User user) {
    System.out.print("Enter account number: ");
    String accountNumber = scanner.nextLine();
    System.out.println("Choose account type (1. Savings, 2. Checking): ");
    int accountType = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    Account account;

    switch (accountType) {
        case 1:
            System.out.print("Enter interest rate: ");
            double interestRate = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account = new SavingsAccount(accountNumber, user, interestRate);
            break;
        case 2:
            System.out.print("Enter overdraft limit: ");
            double overdraftLimit = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account = new CheckingAccount(accountNumber, user, overdraftLimit);
            break;
        default:
            System.out.println("Invalid account type.");
            return;
    }

    bank.addAccount(account);
    System.out.println("Account created successfully.");
}



    private static void depositMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = bank.getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = bank.getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or overdraft limit reached.");
        }
    }

    private static void viewAccountDetails() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = bank.getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println(account);
    }

    private static void viewTransactionHistory() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = bank.getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("\n--- Transaction History ---");
        for (Transaction transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
            System.out.println("-----------------------------");
        }
    }

    private static void deleteAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (bank.getAccount(accountNumber) != null) {
            bank.deleteAccount(accountNumber);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void createUser() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(userId, name, address, contact, password);
        bank.addUser(user);
        System.out.println("User created successfully.");
    }
}
