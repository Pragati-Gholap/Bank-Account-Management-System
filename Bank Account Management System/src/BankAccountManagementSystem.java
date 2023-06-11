import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class BankAccountManagementSystem {
	
	private static Map<Integer, BankAccount> accounts = new HashMap<>();
    private static int accountNumberCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Select an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                checkBalance();
                break;
            case 5:
                isRunning = false;
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
        scanner.close();
    }

    private static void createAccount() {
        BankAccount account = new BankAccount(accountNumberCounter);
        accounts.put(accountNumberCounter, account);
        System.out.println("Account created successfully. Account number: " + accountNumberCounter);
        accountNumberCounter++;
    }

    private static void depositMoney() {
        System.out.print("Enter the account number: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter the account number: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter the account number: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}


