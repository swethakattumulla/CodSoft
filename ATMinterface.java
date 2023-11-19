import java.util.Scanner;

// Class representing a bank account
class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}

// Class representing the ATM
class ATM {
    private Account currentAccount;

    public void insertCard(Account account) {
        this.currentAccount = account;
        System.out.println("Card inserted. Welcome, " + account.getAccountNumber() + "!");
    }

    public void enterPin(String enteredPin) {
        if (currentAccount.validatePin(enteredPin)) {
            System.out.println("PIN accepted. You are now logged in.");
            showOptions();
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }

    private void showOptions() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + currentAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: $" + currentAccount.getBalance());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    currentAccount.withdraw(withdrawalAmount);
                    System.out.println("Withdrawal successful. New balance: $" + currentAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    scanner.close();
            }
        }
    }
}

// Main class for testing the ATM
public class Main {
    public static void main(String[] args) {
        Account userAccount = new Account("123456789", "1234", 1000.0);
        ATM atm = new ATM();

        // Simulate inserting a card
        atm.insertCard(userAccount);

        // Simulate entering a PIN
        atm.enterPin("1234");
    }
}
